package com.dao;

import com.entity.YuezhanxiaoyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuezhanxiaoyuanView;

/**
 * 约战校园 Dao 接口
 *
 * @author 
 */
public interface YuezhanxiaoyuanDao extends BaseMapper<YuezhanxiaoyuanEntity> {

   List<YuezhanxiaoyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
