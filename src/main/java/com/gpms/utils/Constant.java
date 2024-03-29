package com.gpms.utils;

import java.io.File;

public class Constant {
    public static final int ROLE_ADMIN = 1;
    public static final int ROLE_FORBIDDEN = 2;
    public static final int ROLE_VISITOR = 3;
    public static final int ROLE_TEACHER = 4;
    public static final int ROLE_STUDENT = 5;

    public static final String ADMIN = "admin";
    public static final String FORBIDDEN = "forbidden";
    public static final String VISITOR = "visitor";
    public static final String TEACHER = "teacher";
    public static final String STUDENT = "student";
    public static final String ALL = "all";

    public static final String PARAM_TYPE = "type";
    public static final String PARAM_ROLE = "role";
    public static final String PARAM_ALLOTTED = "allotted";

    public static final int PROJECT_STATUS_UNCHECKED = -1;
    public static final int PROJECT_STATUS_CHECKEING = 0;
    public static final int PROJECT_STATUS_DISQUALIFIED = 10;
    public static final int PROJECT_STATUS_QUALIFIED = 11;
    public static final int PROJECT_STATUS_UNCLAIMED = 110;
    public static final int PROJECT_STATUS_CLAIMED = 111;

    public static final int STUDENT_STATUS_UNASSIGNED = 0;
    public static final int STUDENT_STATUS_IDLE = 10;
    public static final int STUDENT_STATUS_WORKING = 11;
    public static final int STUDENT_STATUS_QUALIFIED = 110;
    public static final int STUDENT_STATUS_DISQUALIFIED = 111;

    public static final String FILE_DIR = "S:" + File.separator + "ray" + File.separator + "Desktop" + File.separator + "gpms";

    //webSocket相关配置
    //链接地址
    public static String WEBSOCKETPATHPERFIX = "/ws-push";
    public static String WEBSOCKETPATH = "/endpointWisely";
    //消息代理路径
    public static String WEBSOCKETBROADCASTPATH = "/topic";
    //前端发送给服务端请求地址
    public static final String FORETOSERVERPATH = "/welcome";
    //服务端生产地址,客户端订阅此地址以接收服务端生产的消息
    public static final String PRODUCERPATH = "/topic/getResponse";
    //点对点消息推送地址前缀
    public static final String P2PPUSHBASEPATH = "/user";
    //点对点消息推送地址后缀,最后的地址为/user/用户识别码/msg
    public static final String P2PPUSHPATH = "/msg";

    /**
     * 用户信息在session中存储的变量名
     */
    public static final String SESSION_USER = "SESSION_USER";

    /**
     * 登录页面的回调地址在session中存储的变量名
     */
    public static final String SESSION_LOGIN_REDIRECT_URL = "LOGIN_REDIRECT_URL";

    /**
     * 用户未读的WebSocket消息在Redis中存储的变量名的前缀
     */
    public static final String REDIS_UNREAD_MSG_PREFIX = "stomp-websocket:unread_msg:";
}
