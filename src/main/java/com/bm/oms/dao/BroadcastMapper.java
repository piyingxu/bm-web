package com.bm.oms.dao;


import com.bm.oms.model.Broadcast;
import com.bm.oms.model.CheckinInfo;

import java.util.List;

public interface BroadcastMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Broadcast record);

    int insertSelective(Broadcast record);

    Broadcast selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Broadcast record);

    int updateByPrimaryKey(Broadcast record);

    List<Broadcast> selectAll();
}