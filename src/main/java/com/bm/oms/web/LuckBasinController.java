package com.bm.oms.web;

import com.bm.oms.dao.LuckBasinMapper;
import com.bm.oms.dto.base.RespResult;
import com.bm.oms.dto.base.RespUtil;
import com.bm.oms.model.LuckBasin;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/api/oms")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LuckBasinController {

    @Resource
    private LuckBasinMapper LuckBasinMapper;

    @ApiOperation("1、幸运盆列表")
    @RequestMapping(value = "/luckBasinList", method = RequestMethod.GET)
    public RespResult<List<LuckBasin>> luckBasinList() {
        List<LuckBasin> luckBasinArr = LuckBasinMapper.selectAll();
        RespResult<List<LuckBasin>> rlt = RespUtil.success(luckBasinArr);
        if (luckBasinArr != null) {
            rlt.setCount(luckBasinArr.size());
        }
        return rlt;
    }

    @ApiOperation("2、根据小时获取幸运盆")
    @RequestMapping(value = "/getLuckBasin", method = RequestMethod.GET)
    public RespResult<LuckBasin> getluckBasin(Long id) {
        LuckBasin LuckBasin = LuckBasinMapper.selectByPrimaryKey(id);
        return RespUtil.success(LuckBasin);
    }

    @ApiOperation("3、添加幸运盆")
    @RequestMapping(value = "/addLuckBasin", method = RequestMethod.POST)
    public RespResult<String> addluckBasin(@RequestBody LuckBasin req) {
        LuckBasinMapper.insertSelective(req);
        return RespUtil.success("success");
    }

    @ApiOperation("4、删除幸运盆")
    @RequestMapping(value = "/delLuckBasin", method = RequestMethod.GET)
    public RespResult<String> addluckBasin(Long id) {
        LuckBasinMapper.deleteByPrimaryKey(id);
        return RespUtil.success("success");
    }

    @ApiOperation("5、修改幸运盆")
    @RequestMapping(value = "/upLuckBasin", method = RequestMethod.POST)
    public RespResult<String> upluckBasin(@RequestBody LuckBasin req) {
        LuckBasinMapper.updateByPrimaryKeySelective(req);
        return RespUtil.success("success");
    }



}
