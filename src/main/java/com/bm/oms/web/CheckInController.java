package com.bm.oms.web;

import com.bm.oms.dao.CheckinInfoMapper;
import com.bm.oms.dto.base.RespResult;
import com.bm.oms.dto.base.RespUtil;
import com.bm.oms.dto.res.LoginResponse;
import com.bm.oms.model.CheckinInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/oms")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CheckInController {

    @Resource
    private CheckinInfoMapper checkinInfoMapper;

    @ApiOperation("1、签到列表")
    @RequestMapping(value = "/checkInList", method = RequestMethod.GET)
    public RespResult<List<CheckinInfo>> checkInList() {
        List<CheckinInfo> checkInArr = checkinInfoMapper.selectAll();
        RespResult<List<CheckinInfo>> rlt = RespUtil.success(checkInArr);
        if (checkInArr != null) {
            rlt.setCount(checkInArr.size());
        }
        return rlt;
    }

    @ApiOperation("2、根据小时获取签到")
    @RequestMapping(value = "/getCheckIn", method = RequestMethod.GET)
    public RespResult<CheckinInfo> getCheckIn(Long hour) {
        CheckinInfo checkinInfo = checkinInfoMapper.selectByPrimaryKey(hour);
        return RespUtil.success(checkinInfo);
    }

    @ApiOperation("3、添加签到")
    @RequestMapping(value = "/addCheckIn", method = RequestMethod.POST)
    public RespResult<String> addCheckIn(@RequestBody CheckinInfo req) {
        checkinInfoMapper.insertSelective(req);
        return RespUtil.success("success");
    }

    @ApiOperation("4、删除签到")
    @RequestMapping(value = "/delCheckIn", method = RequestMethod.GET)
    public RespResult<String> addCheckIn(Long hour) {
        checkinInfoMapper.deleteByPrimaryKey(hour);
        return RespUtil.success("success");
    }

    @ApiOperation("5、修改签到")
    @RequestMapping(value = "/upCheckIn", method = RequestMethod.POST)
    public RespResult<String> upCheckIn(@RequestBody CheckinInfo req) {
        checkinInfoMapper.updateByPrimaryKeySelective(req);
        return RespUtil.success("success");
    }



}
