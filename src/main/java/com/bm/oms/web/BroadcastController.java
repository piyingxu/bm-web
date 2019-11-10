package com.bm.oms.web;

import com.bm.oms.dao.BroadcastMapper;
import com.bm.oms.dto.base.RespResult;
import com.bm.oms.dto.base.RespUtil;
import com.bm.oms.model.Broadcast;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/api/oms")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class BroadcastController {

    @Resource
    private BroadcastMapper BroadcastMapper;

    @ApiOperation("1、广播列表")
    @RequestMapping(value = "/broadcastList", method = RequestMethod.GET)
    public RespResult<List<Broadcast>> broadcastList() {
        List<Broadcast> broadcastArr = BroadcastMapper.selectAll();
        RespResult<List<Broadcast>> rlt = RespUtil.success(broadcastArr);
        if (broadcastArr != null) {
            rlt.setCount(broadcastArr.size());
        }
        return rlt;
    }

    @ApiOperation("2、根据主键获取广播")
    @RequestMapping(value = "/getBroadcast", method = RequestMethod.GET)
    public RespResult<Broadcast> getbroadcast(Long id) {
        Broadcast Broadcast = BroadcastMapper.selectByPrimaryKey(id);
        return RespUtil.success(Broadcast);
    }

    @ApiOperation("3、添加广播")
    @RequestMapping(value = "/addBroadcast", method = RequestMethod.POST)
    public RespResult<String> addbroadcast(@RequestBody Broadcast req) {
        BroadcastMapper.insertSelective(req);
        return RespUtil.success("success");
    }

    @ApiOperation("4、删除广播")
    @RequestMapping(value = "/delBroadcast", method = RequestMethod.GET)
    public RespResult<String> addbroadcast(Long id) {
        BroadcastMapper.deleteByPrimaryKey(id);
        return RespUtil.success("success");
    }

    @ApiOperation("5、修改广播")
    @RequestMapping(value = "/upBroadcast", method = RequestMethod.POST)
    public RespResult<String> upbroadcast(@RequestBody Broadcast req) {
        BroadcastMapper.updateByPrimaryKeySelective(req);
        return RespUtil.success("success");
    }



}
