/**
 * api接口列表
 * Created by gameloft9 on 2018/7/19.
 */
layui.define(['$tool','jquery'], function (exports) {

    var $tool = layui.$tool,
        $ = layui.jquery;// 拿到模块变量

    /**
     * 封装一个post
     * */
    function doPost(url,req,successCallback,errorCallback) {
        var jsonReq = JSON.stringify(req);
        $.ajax({
            url:url,
            data:jsonReq,
            contentType:'application/json',
            dataType: "json",
            method:"post",
            success:function (data) {
                successCallback(data);
            },
            error:function (error) {
                errorCallback(error);
            }
        });
    }

    /**
     * 封装一个get
     * */
    function doGet(url,req,successCallback,errorCallback) {
        $.ajax({
            url:url,
            data:req,
            method:"get",
            success:function (data) {
                successCallback(data);
            },
            error:function (error) {
                errorCallback(error);
            }
        });
    }

    /**
     * 封装一个支持更多参数的post
     * */
    function doComplexPost(url,req,config,successCallback,errorCallback) {
        var defaultConfig = {
            url:url,
            data:jsonReq,
            method:"post",
            success:function (data) {
                successCallback(data);
            },
            error:function (error) {
                errorCallback(error);
            }
        };
        var ajaxConfig = $.extend({},config,defaultConfig); // 合并参数

        $.ajax(ajaxConfig);
    }

    // API列表,工程庞大臃肿后可以将API拆分到单独的模块中
    var API = {
        Login: function(req,successCallback,errorCallback){ // 登录
            doGet($tool.getContext() + "/api/oms/login",req,successCallback,errorCallback);
        },
        LogOut:function(req,successCallback,errorCallback){ // 登出
            doPost($tool.getContext() + 'logout.do',req,successCallback,errorCallback);
        },
        ChangePwd:function(req,successCallback,errorCallback){ // 更改密码
            doPost($tool.getContext() + 'personCenter/changePwd.do',req,successCallback,errorCallback);
        },
        AddCheckIn:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'/api/oms/addCheckIn',req,successCallback,errorCallback);
        },
        DelCheckIn:function(req,successCallback,errorCallback) {
            doGet($tool.getContext()+'/api/oms/delCheckIn',req,successCallback,errorCallback);
        },
        GetCheckIn:function(req,successCallback,errorCallback) {
            doGet($tool.getContext()+'/api/oms/getCheckIn',req,successCallback,errorCallback);
        },
        UpCheckIn:function(req,successCallback,errorCallback) {
            doPost($tool.getContext()+'/api/oms/upCheckIn',req,successCallback,errorCallback);
        },
    };




    //输出扩展模块
    exports('$api', API);
});


