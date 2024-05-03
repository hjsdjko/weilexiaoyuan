package com.dao;

import com.entity.DaipiaoCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DaipiaoCollectionView;

/**
 * 代跑收藏 Dao 接口
 *
 * @author 
 */
public interface DaipiaoCollectionDao extends BaseMapper<DaipiaoCollectionEntity> {

   List<DaipiaoCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
