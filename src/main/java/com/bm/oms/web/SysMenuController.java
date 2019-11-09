package com.bm.oms.web;

import com.bm.oms.dto.base.RespResult;
import com.bm.oms.dto.base.RespUtil;
import com.bm.oms.dto.res.MenuTreeResponse;
import com.bm.oms.dto.res.SysMenuTestExtend;
import com.bm.oms.service.SysMenuService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/menu")
public class SysMenuController {

/*    @Autowired
    private SysMenuService sysMenuService;*/



    @ApiOperation("1、获取角色可见菜单列表")
    @RequestMapping(value = "/menuList.do",method = RequestMethod.GET)
    @ResponseBody
    public RespResult getMenuList() {
        //返回json至前端的均返回ResultBean或者PageResultBean
        List<MenuTreeResponse> tempArr = new ArrayList<>();
        MenuTreeResponse obj = new MenuTreeResponse();
        obj.setId("1");
        obj.setTitle("参数配置");
        obj.setIcon("layui-icon-app");
        obj.setHref("http");
        obj.setSpread(false);

        MenuTreeResponse obj1 = new MenuTreeResponse();
        obj1.setId("2");
        obj1.setTitle("签到配置");
        obj1.setIcon("icon-test");
        obj1.setHref("http");
        obj1.setSpread(false);

        obj.getChildren().add(obj1);

        tempArr.add(obj);



        RespResult rlt = RespUtil.success(tempArr);
        return rlt;
    }

/*    *//**
     * 获取所有菜单列表
     * @param page 页序
     * @param limit 分页大小
     * *//*
    @ApiOperation("1、查询菜单")
    @RequestMapping(value = "/menuList.do",method = RequestMethod.POST)
    @ResponseBody
    public RespResult<List<SysMenuTestExtend>> getMenuList(String page, String limit, String menuName, String menuCode, String parentMenuId){
        //返回json至前端的均返回ResultBean或者PageResultBean
        List<SysMenuTestExtend> tempArr = new ArrayList<>();
        SysMenuTestExtend obj = new SysMenuTestExtend();
        obj.setId("1");
        obj.setTitle("参数配置");
        obj.setIcon("icon-test");
        obj.setHref("http");
        tempArr.add(obj);
        RespResult rlt = RespUtil.success(tempArr);
        rlt.setCount(1);
        return rlt;
    }*/


/*
    *//**
     * 获取所有一级菜单列表
     * *//*
    @RequestMapping(value = "/firstClassMenus.do",method = RequestMethod.POST)
    @ResponseBody
    //@BizOperLog(operType = OperType.Query,memo = "获取所有一级菜单列表")
    public RespResult getFirstMenuList(){
        //返回json至前端的均返回ResultBean或者PageResultBean
        return new ResultBean<Collection<SysMenuTest>>(sysMenuServiceImpl.getFirstClassMenus());
    }

    *//**
     * 获取角色可见菜单列表
     * *//*
    @RequestMapping(value = "/menuList.do",method = RequestMethod.GET)
    @ResponseBody
    //@BizOperLog(operType = OperType.Query,memo = "获取角色菜单列表")
    public RespResult getMenuList(){
        //返回json至前端的均返回ResultBean或者PageResultBean
        return new ResultBean<Collection<MenuTreeResponse>>(sysMenuServiceImpl.getMenuByRoles((UserTest) SecurityUtils.getSubject().getPrincipal()));
    }

    *//**
     * 添加菜单
     * *//*
    @RequestMapping(value = "/add.do",method = RequestMethod.POST)
    @ResponseBody
    @BizOperLog(operType = OperType.ADD,memo = "添加菜单")
    public RespResult addMenu(String menuName,String menuUrl,String menuType,String parentMenuId,String requestUrl,String sort){
        //返回json至前端的均返回ResultBean或者PageResultBean
        return new ResultBean<String>(sysMenuServiceImpl.addMenu(menuName,menuUrl,menuType,parentMenuId,requestUrl,sort));
    }

    *//**
     * 删除菜单
     * *//*
    @RequestMapping(value = "/delete.do",method = RequestMethod.POST)
    @ResponseBody
    @BizOperLog(operType = OperType.DELETE,memo = "删除菜单")
    public RespResult deleteMenu(String menuId){
        //返回json至前端的均返回ResultBean或者PageResultBean
        return new ResultBean<Boolean>(sysMenuServiceImpl.deleteMenu(menuId));
    }

    *//**
     * 获取菜单
     * *//*
    @RequestMapping(value = "/get.do",method = RequestMethod.POST)
    @ResponseBody
    public RespResult getMenu(String id){
        //返回json至前端的均返回ResultBean或者PageResultBean
        return new ResultBean<SysMenuTestExtend>(sysMenuServiceImpl.getById(id));
    }*/

}
