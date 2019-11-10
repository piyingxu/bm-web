package com.bm.oms.dao;


import com.bm.oms.model.CheckinInfo;

import java.util.List;

public interface CheckinInfoMapper {

    int deleteByPrimaryKey(Long hour);

    int insertSelective(CheckinInfo record);

    CheckinInfo selectByPrimaryKey(Long hour);

    List<CheckinInfo> selectAll();

    int updateByPrimaryKeySelective(CheckinInfo record);

}