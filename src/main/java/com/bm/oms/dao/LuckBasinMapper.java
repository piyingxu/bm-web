package com.bm.oms.dao;


import com.bm.oms.model.Broadcast;
import com.bm.oms.model.LuckBasin;

import java.util.List;

public interface LuckBasinMapper {

    int deleteByPrimaryKey(Long id);

    int insert(LuckBasin record);

    int insertSelective(LuckBasin record);

    LuckBasin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LuckBasin record);

    int updateByPrimaryKey(LuckBasin record);

    List<LuckBasin> selectAll();
}