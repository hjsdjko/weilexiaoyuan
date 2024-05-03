
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 代跑收藏
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/daipiaoCollection")
public class DaipiaoCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(DaipiaoCollectionController.class);

    private static final String TABLE_NAME = "daipiaoCollection";

    @Autowired
    private DaipiaoCollectionService daipiaoCollectionService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    @Autowired
    private DaipiaoService daipiaoService;
    //注册表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private SijiService sijiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("司机".equals(role))
            params.put("sijiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = daipiaoCollectionService.queryPage(params);

        //字典表数据转换
        List<DaipiaoCollectionView> list =(List<DaipiaoCollectionView>)page.getList();
        for(DaipiaoCollectionView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DaipiaoCollectionEntity daipiaoCollection = daipiaoCollectionService.selectById(id);
        if(daipiaoCollection !=null){
            //entity转view
            DaipiaoCollectionView view = new DaipiaoCollectionView();
            BeanUtils.copyProperties( daipiaoCollection , view );//把实体数据重构到view中
            //级联表 代跑
            //级联表
            DaipiaoEntity daipiao = daipiaoService.selectById(daipiaoCollection.getDaipiaoId());
            if(daipiao != null){
            BeanUtils.copyProperties( daipiao , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setDaipiaoId(daipiao.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(daipiaoCollection.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DaipiaoCollectionEntity daipiaoCollection, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,daipiaoCollection:{}",this.getClass().getName(),daipiaoCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            daipiaoCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<DaipiaoCollectionEntity> queryWrapper = new EntityWrapper<DaipiaoCollectionEntity>()
            .eq("daipiao_id", daipiaoCollection.getDaipiaoId())
            .eq("yonghu_id", daipiaoCollection.getYonghuId())
            .eq("daipiao_collection_types", daipiaoCollection.getDaipiaoCollectionTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaipiaoCollectionEntity daipiaoCollectionEntity = daipiaoCollectionService.selectOne(queryWrapper);
        if(daipiaoCollectionEntity==null){
            daipiaoCollection.setInsertTime(new Date());
            daipiaoCollection.setCreateTime(new Date());
            daipiaoCollectionService.insert(daipiaoCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DaipiaoCollectionEntity daipiaoCollection, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,daipiaoCollection:{}",this.getClass().getName(),daipiaoCollection.toString());
        DaipiaoCollectionEntity oldDaipiaoCollectionEntity = daipiaoCollectionService.selectById(daipiaoCollection.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            daipiaoCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            daipiaoCollectionService.updateById(daipiaoCollection);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<DaipiaoCollectionEntity> oldDaipiaoCollectionList =daipiaoCollectionService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        daipiaoCollectionService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<DaipiaoCollectionEntity> daipiaoCollectionList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            DaipiaoCollectionEntity daipiaoCollectionEntity = new DaipiaoCollectionEntity();
//                            daipiaoCollectionEntity.setDaipiaoId(Integer.valueOf(data.get(0)));   //代跑 要改的
//                            daipiaoCollectionEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            daipiaoCollectionEntity.setDaipiaoCollectionTypes(Integer.valueOf(data.get(0)));   //类型 要改的
//                            daipiaoCollectionEntity.setInsertTime(date);//时间
//                            daipiaoCollectionEntity.setCreateTime(date);//时间
                            daipiaoCollectionList.add(daipiaoCollectionEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        daipiaoCollectionService.insertBatch(daipiaoCollectionList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = daipiaoCollectionService.queryPage(params);

        //字典表数据转换
        List<DaipiaoCollectionView> list =(List<DaipiaoCollectionView>)page.getList();
        for(DaipiaoCollectionView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DaipiaoCollectionEntity daipiaoCollection = daipiaoCollectionService.selectById(id);
            if(daipiaoCollection !=null){


                //entity转view
                DaipiaoCollectionView view = new DaipiaoCollectionView();
                BeanUtils.copyProperties( daipiaoCollection , view );//把实体数据重构到view中

                //级联表
                    DaipiaoEntity daipiao = daipiaoService.selectById(daipiaoCollection.getDaipiaoId());
                if(daipiao != null){
                    BeanUtils.copyProperties( daipiao , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setDaipiaoId(daipiao.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(daipiaoCollection.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody DaipiaoCollectionEntity daipiaoCollection, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,daipiaoCollection:{}",this.getClass().getName(),daipiaoCollection.toString());
        Wrapper<DaipiaoCollectionEntity> queryWrapper = new EntityWrapper<DaipiaoCollectionEntity>()
            .eq("daipiao_id", daipiaoCollection.getDaipiaoId())
            .eq("yonghu_id", daipiaoCollection.getYonghuId())
            .eq("daipiao_collection_types", daipiaoCollection.getDaipiaoCollectionTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaipiaoCollectionEntity daipiaoCollectionEntity = daipiaoCollectionService.selectOne(queryWrapper);
        if(daipiaoCollectionEntity==null){
            daipiaoCollection.setInsertTime(new Date());
            daipiaoCollection.setCreateTime(new Date());
        daipiaoCollectionService.insert(daipiaoCollection);

            return R.ok();
        }else {
            return R.error(511,"您已经收藏过了");
        }
    }

}
