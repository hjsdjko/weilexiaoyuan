package com.dao;

import com.entity.JiaocheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaocheView;

/**
 * 叫车 Dao 接口
 *
 * @author 
 */
public interface JiaocheDao extends BaseMapper<JiaocheEntity> {

   List<JiaocheView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
