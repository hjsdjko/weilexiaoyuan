package com.dao;

import com.entity.DaipiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DaipiaoView;

/**
 * 代跑 Dao 接口
 *
 * @author 
 */
public interface DaipiaoDao extends BaseMapper<DaipiaoEntity> {

   List<DaipiaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
