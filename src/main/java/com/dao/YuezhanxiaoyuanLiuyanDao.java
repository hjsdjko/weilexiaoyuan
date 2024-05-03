package com.dao;

import com.entity.YuezhanxiaoyuanLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuezhanxiaoyuanLiuyanView;

/**
 * 约战校园留言 Dao 接口
 *
 * @author 
 */
public interface YuezhanxiaoyuanLiuyanDao extends BaseMapper<YuezhanxiaoyuanLiuyanEntity> {

   List<YuezhanxiaoyuanLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
