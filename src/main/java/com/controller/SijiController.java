
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
 * 司机
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/siji")
public class SijiController {
    private static final Logger logger = LoggerFactory.getLogger(SijiController.class);

    private static final String TABLE_NAME = "siji";

    @Autowired
    private SijiService sijiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    //注册表service
    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = sijiService.queryPage(params);

        //字典表数据转换
        List<SijiView> list =(List<SijiView>)page.getList();
        for(SijiView c:list){
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
        SijiEntity siji = sijiService.selectById(id);
        if(siji !=null){
            //entity转view
            SijiView view = new SijiView();
            BeanUtils.copyProperties( siji , view );//把实体数据重构到view中
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
    public R save(@RequestBody SijiEntity siji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,siji:{}",this.getClass().getName(),siji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<SijiEntity> queryWrapper = new EntityWrapper<SijiEntity>()
            .eq("username", siji.getUsername())
            .or()
            .eq("siji_phone", siji.getSijiPhone())
            .or()
            .eq("siji_id_number", siji.getSijiIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SijiEntity sijiEntity = sijiService.selectOne(queryWrapper);
        if(sijiEntity==null){
            siji.setCreateTime(new Date());
            siji.setPassword("123456");
            sijiService.insert(siji);
            return R.ok();
        }else {
            return R.error(511,"账户或者司机手机号或者司机身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SijiEntity siji, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,siji:{}",this.getClass().getName(),siji.toString());
        SijiEntity oldSijiEntity = sijiService.selectById(siji.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(siji.getSijiPhoto()) || "null".equals(siji.getSijiPhoto())){
                siji.setSijiPhoto(null);
        }

            sijiService.updateById(siji);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<SijiEntity> oldSijiList =sijiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        sijiService.deleteBatchIds(Arrays.asList(ids));

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
            List<SijiEntity> sijiList = new ArrayList<>();//上传的东西
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
                            SijiEntity sijiEntity = new SijiEntity();
//                            sijiEntity.setUsername(data.get(0));                    //账户 要改的
//                            //sijiEntity.setPassword("123456");//密码
//                            sijiEntity.setSijiName(data.get(0));                    //司机姓名 要改的
//                            sijiEntity.setSijiPhone(data.get(0));                    //司机手机号 要改的
//                            sijiEntity.setSijiIdNumber(data.get(0));                    //司机身份证号 要改的
//                            sijiEntity.setSijiPhoto("");//详情和图片
//                            sijiEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            sijiEntity.setNewMoney(data.get(0));                    //余额 要改的
//                            sijiEntity.setSijiEmail(data.get(0));                    //电子邮箱 要改的
//                            sijiEntity.setCreateTime(date);//时间
                            sijiList.add(sijiEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //司机手机号
                                if(seachFields.containsKey("sijiPhone")){
                                    List<String> sijiPhone = seachFields.get("sijiPhone");
                                    sijiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> sijiPhone = new ArrayList<>();
                                    sijiPhone.add(data.get(0));//要改的
                                    seachFields.put("sijiPhone",sijiPhone);
                                }
                                //司机身份证号
                                if(seachFields.containsKey("sijiIdNumber")){
                                    List<String> sijiIdNumber = seachFields.get("sijiIdNumber");
                                    sijiIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> sijiIdNumber = new ArrayList<>();
                                    sijiIdNumber.add(data.get(0));//要改的
                                    seachFields.put("sijiIdNumber",sijiIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<SijiEntity> sijiEntities_username = sijiService.selectList(new EntityWrapper<SijiEntity>().in("username", seachFields.get("username")));
                        if(sijiEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SijiEntity s:sijiEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //司机手机号
                        List<SijiEntity> sijiEntities_sijiPhone = sijiService.selectList(new EntityWrapper<SijiEntity>().in("siji_phone", seachFields.get("sijiPhone")));
                        if(sijiEntities_sijiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SijiEntity s:sijiEntities_sijiPhone){
                                repeatFields.add(s.getSijiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [司机手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //司机身份证号
                        List<SijiEntity> sijiEntities_sijiIdNumber = sijiService.selectList(new EntityWrapper<SijiEntity>().in("siji_id_number", seachFields.get("sijiIdNumber")));
                        if(sijiEntities_sijiIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SijiEntity s:sijiEntities_sijiIdNumber){
                                repeatFields.add(s.getSijiIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [司机身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        sijiService.insertBatch(sijiList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        SijiEntity siji = sijiService.selectOne(new EntityWrapper<SijiEntity>().eq("username", username));
        if(siji==null || !siji.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(siji.getId(),username, "siji", "司机");
        R r = R.ok();
        r.put("token", token);
        r.put("role","司机");
        r.put("username",siji.getSijiName());
        r.put("tableName","siji");
        r.put("userId",siji.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody SijiEntity siji, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<SijiEntity> queryWrapper = new EntityWrapper<SijiEntity>()
            .eq("username", siji.getUsername())
            .or()
            .eq("siji_phone", siji.getSijiPhone())
            .or()
            .eq("siji_id_number", siji.getSijiIdNumber())
            ;
        SijiEntity sijiEntity = sijiService.selectOne(queryWrapper);
        if(sijiEntity != null)
            return R.error("账户或者司机手机号或者司机身份证号已经被使用");
        siji.setNewMoney(0.0);
        siji.setCreateTime(new Date());
        sijiService.insert(siji);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        SijiEntity siji = sijiService.selectById(id);
        siji.setPassword("123456");
        sijiService.updateById(siji);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        SijiEntity siji = sijiService.selectOne(new EntityWrapper<SijiEntity>().eq("username", username));
        if(siji!=null){
            siji.setPassword("123456");
            boolean b = sijiService.updateById(siji);
            if(!b){
               return R.error();
            }
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrSiji(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        SijiEntity siji = sijiService.selectById(id);
        if(siji !=null){
            //entity转view
            SijiView view = new SijiView();
            BeanUtils.copyProperties( siji , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = sijiService.queryPage(params);

        //字典表数据转换
        List<SijiView> list =(List<SijiView>)page.getList();
        for(SijiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SijiEntity siji = sijiService.selectById(id);
            if(siji !=null){


                //entity转view
                SijiView view = new SijiView();
                BeanUtils.copyProperties( siji , view );//把实体数据重构到view中

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
    public R add(@RequestBody SijiEntity siji, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,siji:{}",this.getClass().getName(),siji.toString());
        Wrapper<SijiEntity> queryWrapper = new EntityWrapper<SijiEntity>()
            .eq("username", siji.getUsername())
            .or()
            .eq("siji_phone", siji.getSijiPhone())
            .or()
            .eq("siji_id_number", siji.getSijiIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SijiEntity sijiEntity = sijiService.selectOne(queryWrapper);
        if(sijiEntity==null){
            siji.setCreateTime(new Date());
        siji.setPassword("123456");
        sijiService.insert(siji);

            return R.ok();
        }else {
            return R.error(511,"账户或者司机手机号或者司机身份证号已经被使用");
        }
    }

}
