package com.dao;

import com.entity.JiaocheChatEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaocheChatView;

/**
 * 用户咨询 Dao 接口
 *
 * @author 
 */
public interface JiaocheChatDao extends BaseMapper<JiaocheChatEntity> {

   List<JiaocheChatView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
