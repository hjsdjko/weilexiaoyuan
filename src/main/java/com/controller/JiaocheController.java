
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
 * 叫车
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiaoche")
public class JiaocheController {
    private static final Logger logger = LoggerFactory.getLogger(JiaocheController.class);

    private static final String TABLE_NAME = "jiaoche";

    @Autowired
    private JiaocheService jiaocheService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

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
        PageUtils page = jiaocheService.queryPage(params);

        //字典表数据转换
        List<JiaocheView> list =(List<JiaocheView>)page.getList();
        for(JiaocheView c:list){
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
        JiaocheEntity jiaoche = jiaocheService.selectById(id);
        if(jiaoche !=null){
            //entity转view
            JiaocheView view = new JiaocheView();
            BeanUtils.copyProperties( jiaoche , view );//把实体数据重构到view中
            //级联表 司机
            //级联表
            SijiEntity siji = sijiService.selectById(jiaoche.getSijiId());
            if(siji != null){
            BeanUtils.copyProperties( siji , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "sijiId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setSijiId(siji.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jiaoche.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "sijiId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
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
    public R save(@RequestBody JiaocheEntity jiaoche, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaoche:{}",this.getClass().getName(),jiaoche.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("司机".equals(role))
            jiaoche.setSijiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("用户".equals(role))
            jiaoche.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiaocheEntity> queryWrapper = new EntityWrapper<JiaocheEntity>()
            .eq("yonghu_id", jiaoche.getYonghuId())
            .eq("siji_id", jiaoche.getSijiId())
            .eq("jiaoche_name", jiaoche.getJiaocheName())
            .eq("jiaoche_address", jiaoche.getJiaocheAddress())
            .eq("jiaoche_quwang_address", jiaoche.getJiaocheQuwangAddress())
            .eq("jiaoche_types", jiaoche.getJiaocheTypes())
            .eq("jiaoche_zhuangtai_types", jiaoche.getJiaocheZhuangtaiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaocheEntity jiaocheEntity = jiaocheService.selectOne(queryWrapper);
        if(jiaocheEntity==null){
            jiaoche.setInsertTime(new Date());
            jiaoche.setCreateTime(new Date());
            jiaocheService.insert(jiaoche);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaocheEntity jiaoche, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiaoche:{}",this.getClass().getName(),jiaoche.toString());
        JiaocheEntity oldJiaocheEntity = jiaocheService.selectById(jiaoche.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("司机".equals(role))
//            jiaoche.setSijiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("用户".equals(role))
//            jiaoche.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jiaoche.getJiaochePhoto()) || "null".equals(jiaoche.getJiaochePhoto())){
                jiaoche.setJiaochePhoto(null);
        }

            jiaocheService.updateById(jiaoche);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiaocheEntity> oldJiaocheList =jiaocheService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jiaocheService.deleteBatchIds(Arrays.asList(ids));

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
            List<JiaocheEntity> jiaocheList = new ArrayList<>();//上传的东西
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
                            JiaocheEntity jiaocheEntity = new JiaocheEntity();
//                            jiaocheEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jiaocheEntity.setSijiId(Integer.valueOf(data.get(0)));   //司机 要改的
//                            jiaocheEntity.setJiaocheUuidNumber(data.get(0));                    //叫车编号 要改的
//                            jiaocheEntity.setJiaocheName(data.get(0));                    //叫车标题 要改的
//                            jiaocheEntity.setJiaochePhoto("");//详情和图片
//                            jiaocheEntity.setShangcheTime(sdf.parse(data.get(0)));          //上车时间 要改的
//                            jiaocheEntity.setJiaocheAddress(data.get(0));                    //上车地点 要改的
//                            jiaocheEntity.setJiaocheQuwangAddress(data.get(0));                    //去往地点 要改的
//                            jiaocheEntity.setJiaocheTypes(Integer.valueOf(data.get(0)));   //叫车类型 要改的
//                            jiaocheEntity.setJiaocheNewMoney(data.get(0));                    //出价 要改的
//                            jiaocheEntity.setJiaocheContent("");//详情和图片
//                            jiaocheEntity.setInsertTime(date);//时间
//                            jiaocheEntity.setJiaocheZhuangtaiTypes(Integer.valueOf(data.get(0)));   //叫车状态 要改的
//                            jiaocheEntity.setCreateTime(date);//时间
                            jiaocheList.add(jiaocheEntity);


                            //把要查询是否重复的字段放入map中
                                //叫车编号
                                if(seachFields.containsKey("jiaocheUuidNumber")){
                                    List<String> jiaocheUuidNumber = seachFields.get("jiaocheUuidNumber");
                                    jiaocheUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiaocheUuidNumber = new ArrayList<>();
                                    jiaocheUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiaocheUuidNumber",jiaocheUuidNumber);
                                }
                        }

                        //查询是否重复
                         //叫车编号
                        List<JiaocheEntity> jiaocheEntities_jiaocheUuidNumber = jiaocheService.selectList(new EntityWrapper<JiaocheEntity>().in("jiaoche_uuid_number", seachFields.get("jiaocheUuidNumber")));
                        if(jiaocheEntities_jiaocheUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiaocheEntity s:jiaocheEntities_jiaocheUuidNumber){
                                repeatFields.add(s.getJiaocheUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [叫车编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiaocheService.insertBatch(jiaocheList);
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
        PageUtils page = jiaocheService.queryPage(params);

        //字典表数据转换
        List<JiaocheView> list =(List<JiaocheView>)page.getList();
        for(JiaocheView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaocheEntity jiaoche = jiaocheService.selectById(id);
            if(jiaoche !=null){

                //entity转view
                JiaocheView view = new JiaocheView();
                BeanUtils.copyProperties( jiaoche , view );//把实体数据重构到view中

                //级联表
                    SijiEntity siji = sijiService.selectById(jiaoche.getSijiId());
                if(siji != null){
                    BeanUtils.copyProperties( siji , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSijiId(siji.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jiaoche.getYonghuId());
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
    * 前端详情
    */
    @RequestMapping("/querenshiyong/{id}")
    public R querenshiyong(@PathVariable("id")  Long id, HttpServletRequest request){
        JiaocheEntity jiaoche = jiaocheService.selectById(id);
        if(jiaoche== null)
            return R.error("查不到叫车信息");

        SijiEntity sijiEntity = sijiService.selectById(jiaoche.getSijiId());
        if(sijiEntity == null){
            return R.error("查不到司机");
        }
        sijiEntity.setNewMoney(sijiEntity.getNewMoney()+jiaoche.getJiaocheNewMoney());
        sijiService.updateById(sijiEntity);

        jiaoche.setJiaocheZhuangtaiTypes(4);
        jiaocheService.updateById(jiaoche);

        return R.ok();

    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JiaocheEntity jiaoche, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiaoche:{}",this.getClass().getName(),jiaoche.toString());
        Wrapper<JiaocheEntity> queryWrapper = new EntityWrapper<JiaocheEntity>()
            .eq("yonghu_id", jiaoche.getYonghuId())
            .eq("jiaoche_uuid_number", jiaoche.getJiaocheUuidNumber())
            .eq("jiaoche_name", jiaoche.getJiaocheName())
            .eq("jiaoche_address", jiaoche.getJiaocheAddress())
            .eq("jiaoche_quwang_address", jiaoche.getJiaocheQuwangAddress())
            .eq("jiaoche_types", jiaoche.getJiaocheTypes())
            .eq("jiaoche_zhuangtai_types", jiaoche.getJiaocheZhuangtaiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaocheEntity jiaocheEntity = jiaocheService.selectOne(queryWrapper);
        if(jiaocheEntity==null){

            YonghuEntity yonghuEntity = yonghuService.selectById(jiaoche.getYonghuId());
            if(yonghuEntity == null)
                return R.error("查不到用户");
            double balance = yonghuEntity.getNewMoney() - jiaoche.getJiaocheNewMoney();
            if(balance<0){
                return R.error("账户余额不足,请充值后再叫车");
            }

            yonghuEntity.setNewMoney(balance);
            yonghuService.updateById(yonghuEntity);

            jiaoche.setInsertTime(new Date());
            jiaoche.setCreateTime(new Date());
        jiaocheService.insert(jiaoche);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
