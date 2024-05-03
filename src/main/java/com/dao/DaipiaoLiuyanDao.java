package com.dao;

import com.entity.DaipiaoLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DaipiaoLiuyanView;

/**
 * 代跑留言 Dao 接口
 *
 * @author 
 */
public interface DaipiaoLiuyanDao extends BaseMapper<DaipiaoLiuyanEntity> {

   List<DaipiaoLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
