package com.bm.oms.config;

import com.bm.oms.dto.base.BaseEntity;
import com.bm.oms.dto.res.MenuTreeResponse;
import java.util.ArrayList;
import java.util.List;

public class OmsConfiguration extends BaseEntity {

    public static List<MenuTreeResponse> menuArr = new ArrayList<>();
    static {
        MenuTreeResponse p1 = new MenuTreeResponse("参数配置",null);
        MenuTreeResponse p1s1 = new MenuTreeResponse("签到配置","page/system/checkin/allCheckIn.html");
        MenuTreeResponse p1s2 = new MenuTreeResponse("幸运盆配置","page/system/luckBasin/allLuckBasin.html");
        MenuTreeResponse p1s3 = new MenuTreeResponse("提现配置","page/system/luckBasin/allLuckBasin.html");
        MenuTreeResponse p1s4 = new MenuTreeResponse("广告配置","page/system/luckBasin/allLuckBasin.html");
        MenuTreeResponse p1s5 = new MenuTreeResponse("滚报配置","page/system/broadcast/allBroadcast.html");
        p1.getChildren().add(p1s1);p1.getChildren().add(p1s2);p1.getChildren().add(p1s3);
        p1.getChildren().add(p1s4);p1.getChildren().add(p1s5);

        MenuTreeResponse p2 = new MenuTreeResponse("玩家信息",null);
        MenuTreeResponse p2s1 = new MenuTreeResponse("个人信息","page/system/luckBasin/allLuckBasin.html");
        MenuTreeResponse p2s2 = new MenuTreeResponse("游戏记录","page/system/luckBasin/allLuckBasin.html");
        MenuTreeResponse p2s3 = new MenuTreeResponse("金币变动","page/system/luckBasin/allLuckBasin.html");
        MenuTreeResponse p2s4 = new MenuTreeResponse("道具添加","page/system/luckBasin/allLuckBasin.html");
        p2.getChildren().add(p2s1);p2.getChildren().add(p2s2);p2.getChildren().add(p2s3);
        p2.getChildren().add(p2s4);

        MenuTreeResponse p3 = new MenuTreeResponse("日志汇总",null);
        MenuTreeResponse p3s1 = new MenuTreeResponse("登录日志","page/system/luckBasin/allLuckBasin.html");
        MenuTreeResponse p3s2 = new MenuTreeResponse("留存汇总","page/system/luckBasin/allLuckBasin.html");
        p3.getChildren().add(p3s1);p3.getChildren().add(p3s2);

        MenuTreeResponse p4 = new MenuTreeResponse("系统管理",null);
        MenuTreeResponse p4s1 = new MenuTreeResponse("用户管理","page/system/luckBasin/allLuckBasin.html");
        MenuTreeResponse p4s2 = new MenuTreeResponse("操作日志","page/system/luckBasin/allLuckBasin.html");
        p4.getChildren().add(p4s1);p4.getChildren().add(p4s2);

        menuArr.add(p1);
        menuArr.add(p2);
        menuArr.add(p3);
        menuArr.add(p4);
    }



}
