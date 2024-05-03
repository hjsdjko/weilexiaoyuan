
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
 * 代跑订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/daipiaoOrder")
public class DaipiaoOrderController {
    private static final Logger logger = LoggerFactory.getLogger(DaipiaoOrderController.class);

    private static final String TABLE_NAME = "daipiaoOrder";

    @Autowired
    private DaipiaoOrderService daipiaoOrderService;


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
        PageUtils page = daipiaoOrderService.queryPage(params);

        //字典表数据转换
        List<DaipiaoOrderView> list =(List<DaipiaoOrderView>)page.getList();
        for(DaipiaoOrderView c:list){
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
        DaipiaoOrderEntity daipiaoOrder = daipiaoOrderService.selectById(id);
        if(daipiaoOrder !=null){
            //entity转view
            DaipiaoOrderView view = new DaipiaoOrderView();
            BeanUtils.copyProperties( daipiaoOrder , view );//把实体数据重构到view中
            //级联表 代跑
            //级联表
            DaipiaoEntity daipiao = daipiaoService.selectById(daipiaoOrder.getDaipiaoId());
            if(daipiao != null){
            BeanUtils.copyProperties( daipiao , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setDaipiaoId(daipiao.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(daipiaoOrder.getYonghuId());
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
    public R save(@RequestBody DaipiaoOrderEntity daipiaoOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,daipiaoOrder:{}",this.getClass().getName(),daipiaoOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            daipiaoOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        daipiaoOrder.setCreateTime(new Date());
        daipiaoOrder.setInsertTime(new Date());
        daipiaoOrderService.insert(daipiaoOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DaipiaoOrderEntity daipiaoOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,daipiaoOrder:{}",this.getClass().getName(),daipiaoOrder.toString());
        DaipiaoOrderEntity oldDaipiaoOrderEntity = daipiaoOrderService.selectById(daipiaoOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            daipiaoOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            daipiaoOrderService.updateById(daipiaoOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<DaipiaoOrderEntity> oldDaipiaoOrderList =daipiaoOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        daipiaoOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<DaipiaoOrderEntity> daipiaoOrderList = new ArrayList<>();//上传的东西
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
                            DaipiaoOrderEntity daipiaoOrderEntity = new DaipiaoOrderEntity();
//                            daipiaoOrderEntity.setDaipiaoOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            daipiaoOrderEntity.setDaipiaoId(Integer.valueOf(data.get(0)));   //代跑 要改的
//                            daipiaoOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            daipiaoOrderEntity.setDaipiaoOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            daipiaoOrderEntity.setDaipiaoOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            daipiaoOrderEntity.setDaipiaoOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            daipiaoOrderEntity.setInsertTime(date);//时间
//                            daipiaoOrderEntity.setCreateTime(date);//时间
                            daipiaoOrderList.add(daipiaoOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("daipiaoOrderUuidNumber")){
                                    List<String> daipiaoOrderUuidNumber = seachFields.get("daipiaoOrderUuidNumber");
                                    daipiaoOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> daipiaoOrderUuidNumber = new ArrayList<>();
                                    daipiaoOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("daipiaoOrderUuidNumber",daipiaoOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<DaipiaoOrderEntity> daipiaoOrderEntities_daipiaoOrderUuidNumber = daipiaoOrderService.selectList(new EntityWrapper<DaipiaoOrderEntity>().in("daipiao_order_uuid_number", seachFields.get("daipiaoOrderUuidNumber")));
                        if(daipiaoOrderEntities_daipiaoOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DaipiaoOrderEntity s:daipiaoOrderEntities_daipiaoOrderUuidNumber){
                                repeatFields.add(s.getDaipiaoOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        daipiaoOrderService.insertBatch(daipiaoOrderList);
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
        PageUtils page = daipiaoOrderService.queryPage(params);

        //字典表数据转换
        List<DaipiaoOrderView> list =(List<DaipiaoOrderView>)page.getList();
        for(DaipiaoOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DaipiaoOrderEntity daipiaoOrder = daipiaoOrderService.selectById(id);
            if(daipiaoOrder !=null){


                //entity转view
                DaipiaoOrderView view = new DaipiaoOrderView();
                BeanUtils.copyProperties( daipiaoOrder , view );//把实体数据重构到view中

                //级联表
                    DaipiaoEntity daipiao = daipiaoService.selectById(daipiaoOrder.getDaipiaoId());
                if(daipiao != null){
                    BeanUtils.copyProperties( daipiao , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setDaipiaoId(daipiao.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(daipiaoOrder.getYonghuId());
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
    public R add(@RequestBody DaipiaoOrderEntity daipiaoOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,daipiaoOrder:{}",this.getClass().getName(),daipiaoOrder.toString());
            DaipiaoEntity daipiaoEntity = daipiaoService.selectById(daipiaoOrder.getDaipiaoId());
            if(daipiaoEntity == null){
                return R.error(511,"查不到该代跑");
            }
            // Double daipiaoNewMoney = daipiaoEntity.getDaipiaoNewMoney();

            if(false){
            }
            else if(daipiaoEntity.getDaipiaoNewMoney() == null){
                return R.error(511,"代跑金额不能为空");
            }

        daipiaoEntity.setDaipiaoZhuangtaiTypes(2);
        daipiaoService.updateById(daipiaoEntity);//更新代跑状态为已代跑,防止多人抢单情况

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            daipiaoOrder.setDaipiaoOrderTypes(101); //设置订单状态为已申请代跑
            daipiaoOrder.setDaipiaoOrderTruePrice(daipiaoEntity.getDaipiaoNewMoney()); //设置实付价格
            daipiaoOrder.setYonghuId(userId); //设置代跑人
            daipiaoOrder.setDaipiaoOrderUuidNumber(String.valueOf(new Date().getTime()));
            daipiaoOrder.setDaipiaoOrderPaymentTypes(1);
            daipiaoOrder.setInsertTime(new Date());
            daipiaoOrder.setCreateTime(new Date());
            daipiaoOrderService.insert(daipiaoOrder);//新增订单

            return R.ok();
    }


    /**
    * 取消代跑
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);

            DaipiaoOrderEntity daipiaoOrder = daipiaoOrderService.selectById(id);
            Integer daipiaoId = daipiaoOrder.getDaipiaoId();
            if(daipiaoId == null)
                return R.error(511,"查不到该代跑");
            DaipiaoEntity daipiaoEntity = daipiaoService.selectById(daipiaoId);
            if(daipiaoEntity == null)
                return R.error(511,"查不到该代跑");




            daipiaoOrder.setDaipiaoOrderTypes(102);//设置订单状态为已取消代跑
            daipiaoOrderService.updateById(daipiaoOrder);//根据id更新



            daipiaoEntity.setDaipiaoZhuangtaiTypes(1);
            daipiaoService.updateById(daipiaoEntity);//更新订单中代跑的信息

            return R.ok();
    }

    /**
     * 接受
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        DaipiaoOrderEntity  daipiaoOrderEntity = daipiaoOrderService.selectById(id);

        DaipiaoEntity daipiaoEntity = daipiaoService.selectById(daipiaoOrderEntity.getDaipiaoId());
        if(daipiaoEntity== null)
            return R.error("查不到代跑信息");

        YonghuEntity yonghuEntity = yonghuService.selectById(daipiaoOrderEntity.getYonghuId());//代跑人
        yonghuEntity.setNewMoney(yonghuEntity.getNewMoney()+daipiaoEntity.getDaipiaoNewMoney());
        yonghuService.updateById(yonghuEntity);
        

        daipiaoOrderEntity.setDaipiaoOrderTypes(103);//设置订单状态为已接受
       daipiaoOrderService.updateById( daipiaoOrderEntity);


        return R.ok();
    }


}
