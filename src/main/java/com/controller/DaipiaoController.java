
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
 * 代跑
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/daipiao")
public class DaipiaoController {
    private static final Logger logger = LoggerFactory.getLogger(DaipiaoController.class);

    private static final String TABLE_NAME = "daipiao";

    @Autowired
    private DaipiaoService daipiaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private DaipiaoOrderService daipiaoOrderService;
    @Autowired
    private DaipiaoCollectionService daipiaoCollectionService;
    //级联表非注册的service
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
        PageUtils page = daipiaoService.queryPage(params);

        //字典表数据转换
        List<DaipiaoView> list =(List<DaipiaoView>)page.getList();
        for(DaipiaoView c:list){
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
        DaipiaoEntity daipiao = daipiaoService.selectById(id);
        if(daipiao !=null){
            //entity转view
            DaipiaoView view = new DaipiaoView();
            BeanUtils.copyProperties( daipiao , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(daipiao.getYonghuId());
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
    public R save(@RequestBody DaipiaoEntity daipiao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,daipiao:{}",this.getClass().getName(),daipiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            daipiao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<DaipiaoEntity> queryWrapper = new EntityWrapper<DaipiaoEntity>()
            .eq("yonghu_id", daipiao.getYonghuId())
            .eq("daipiao_name", daipiao.getDaipiaoName())
            .eq("daipiao_address", daipiao.getDaipiaoAddress())
            .eq("daipiao_lianxiren", daipiao.getDaipiaoLianxiren())
            .eq("daipiao_lianxifangshi", daipiao.getDaipiaoLianxifangshi())
            .eq("daipiao_types", daipiao.getDaipiaoTypes())
            .eq("daipiao_zhuangtai_types", daipiao.getDaipiaoZhuangtaiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaipiaoEntity daipiaoEntity = daipiaoService.selectOne(queryWrapper);
        if(daipiaoEntity==null){
            daipiao.setInsertTime(new Date());
            daipiao.setCreateTime(new Date());
            daipiaoService.insert(daipiao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DaipiaoEntity daipiao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,daipiao:{}",this.getClass().getName(),daipiao.toString());
        DaipiaoEntity oldDaipiaoEntity = daipiaoService.selectById(daipiao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            daipiao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(daipiao.getDaipiaoPhoto()) || "null".equals(daipiao.getDaipiaoPhoto())){
                daipiao.setDaipiaoPhoto(null);
        }

            daipiaoService.updateById(daipiao);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<DaipiaoEntity> oldDaipiaoList =daipiaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        daipiaoService.deleteBatchIds(Arrays.asList(ids));

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
            List<DaipiaoEntity> daipiaoList = new ArrayList<>();//上传的东西
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
                            DaipiaoEntity daipiaoEntity = new DaipiaoEntity();
//                            daipiaoEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            daipiaoEntity.setDaipiaoName(data.get(0));                    //代跑标题 要改的
//                            daipiaoEntity.setDaipiaoPhoto("");//详情和图片
//                            daipiaoEntity.setDaipiaoAddress(data.get(0));                    //代跑地点 要改的
//                            daipiaoEntity.setDaipiaoLianxiren(data.get(0));                    //联系人 要改的
//                            daipiaoEntity.setDaipiaoLianxifangshi(data.get(0));                    //联系方式 要改的
//                            daipiaoEntity.setDaipiaoTypes(Integer.valueOf(data.get(0)));   //代跑类型 要改的
//                            daipiaoEntity.setDaipiaoNewMoney(data.get(0));                    //代跑金额 要改的
//                            daipiaoEntity.setDaipiaoTime(sdf.parse(data.get(0)));          //代跑时间 要改的
//                            daipiaoEntity.setDaipiaoContent("");//详情和图片
//                            daipiaoEntity.setDaipiaoZhuangtaiTypes(Integer.valueOf(data.get(0)));   //代跑状态 要改的
//                            daipiaoEntity.setInsertTime(date);//时间
//                            daipiaoEntity.setCreateTime(date);//时间
                            daipiaoList.add(daipiaoEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        daipiaoService.insertBatch(daipiaoList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<DaipiaoView> returnDaipiaoViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = daipiaoOrderService.queryPage(params1);
        List<DaipiaoOrderView> orderViewsList =(List<DaipiaoOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(DaipiaoOrderView orderView:orderViewsList){
            Integer daipiaoTypes = orderView.getDaipiaoTypes();
            if(typeMap.containsKey(daipiaoTypes)){
                typeMap.put(daipiaoTypes,typeMap.get(daipiaoTypes)+1);
            }else{
                typeMap.put(daipiaoTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("daipiaoTypes",type);
            PageUtils pageUtils1 = daipiaoService.queryPage(params2);
            List<DaipiaoView> daipiaoViewList =(List<DaipiaoView>)pageUtils1.getList();
            returnDaipiaoViewList.addAll(daipiaoViewList);
            if(returnDaipiaoViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = daipiaoService.queryPage(params);
        if(returnDaipiaoViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnDaipiaoViewList.size();//要添加的数量
            List<DaipiaoView> daipiaoViewList =(List<DaipiaoView>)page.getList();
            for(DaipiaoView daipiaoView:daipiaoViewList){
                Boolean addFlag = true;
                for(DaipiaoView returnDaipiaoView:returnDaipiaoViewList){
                    if(returnDaipiaoView.getId().intValue() ==daipiaoView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnDaipiaoViewList.add(daipiaoView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnDaipiaoViewList = returnDaipiaoViewList.subList(0, limit);
        }

        for(DaipiaoView c:returnDaipiaoViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnDaipiaoViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = daipiaoService.queryPage(params);

        //字典表数据转换
        List<DaipiaoView> list =(List<DaipiaoView>)page.getList();
        for(DaipiaoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DaipiaoEntity daipiao = daipiaoService.selectById(id);
            if(daipiao !=null){


                //entity转view
                DaipiaoView view = new DaipiaoView();
                BeanUtils.copyProperties( daipiao , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(daipiao.getYonghuId());
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
    public R add(@RequestBody DaipiaoEntity daipiao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,daipiao:{}",this.getClass().getName(),daipiao.toString());
        Wrapper<DaipiaoEntity> queryWrapper = new EntityWrapper<DaipiaoEntity>()
            .eq("yonghu_id", daipiao.getYonghuId())
            .eq("daipiao_name", daipiao.getDaipiaoName())
            .eq("daipiao_address", daipiao.getDaipiaoAddress())
            .eq("daipiao_lianxiren", daipiao.getDaipiaoLianxiren())
            .eq("daipiao_lianxifangshi", daipiao.getDaipiaoLianxifangshi())
            .eq("daipiao_types", daipiao.getDaipiaoTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaipiaoEntity daipiaoEntity = daipiaoService.selectOne(queryWrapper);
        if(daipiaoEntity==null){
            daipiao.setInsertTime(new Date());
            daipiao.setCreateTime(new Date());


            if(daipiao.getDaipiaoNewMoney()<0){
                return R.error("代跑金额不能小于0");
            }

            YonghuEntity yonghuEntity = yonghuService.selectById(daipiao.getYonghuId());
            if(yonghuEntity==null)
                return R.error("查不到发布代跑的用户");
            if(yonghuEntity.getNewMoney() == null)
                return R.error("查不到发布代跑的用户的金额");

            double balance = yonghuEntity.getNewMoney() - daipiao.getDaipiaoNewMoney();
            if(balance<0)
                return R.error("代跑金额大于余额,请充值后再发布");
            yonghuEntity.setNewMoney(balance);
//            yonghuService.updateById(yonghuEntity);



            daipiao.setDaipiaoZhuangtaiTypes(1);
            daipiaoService.insert(daipiao);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
