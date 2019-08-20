package com.example.baselibrary.mvp.entity;

/**
 * @ProjectName: GitCode
 * @Package: driver.cunniao.cn.mvp.entity
 * @ClassName: LoginRequest
 * @Description:
 * @Author: liwei
 * @CreateDate: 2018/10/24 0024 15:33
 * @Version: 1.0
 * @weChat 18571658038
 */
public class LoginRequest {

    /**
     * password : 96e79218965eb72c92a549dd5a330112
     * loginMode : 1
     * userid : 18915329001
     * clientInfo : {"vender":"APPLE","appVersion":"1.0.0","osVersion":"12.0","deviceID":"FCBC863E-0955-462A-AA33-76EBB4D25E3E","sdkVersion":"","deviceType":2,"iosToken":"70cbadc8102fe020fd179b73c34b6951a50a239e22ffa386d36eb69d813fda87","publishChannel":"APPSTORE","net":"WIFI"}
     * role : 2
     * authCode :
     */

    private String password;
    private int loginMode;
    private String userid;
    private ClientInfoBean clientInfo;
    private int role;
    private String authCode;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoginMode() {
        return loginMode;
    }

    public void setLoginMode(int loginMode) {
        this.loginMode = loginMode;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public ClientInfoBean getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfoBean clientInfo) {
        this.clientInfo = clientInfo;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public static class ClientInfoBean {
        /**
         * vender : APPLE
         * appVersion : 1.0.0
         * osVersion : 12.0
         * deviceID : FCBC863E-0955-462A-AA33-76EBB4D25E3E
         * sdkVersion :
         * deviceType : 2
         * iosToken : 70cbadc8102fe020fd179b73c34b6951a50a239e22ffa386d36eb69d813fda87
         * publishChannel : APPSTORE
         * net : WIFI
         */

        private String vender;
        private String appVersion;
        private String osVersion;
        private String deviceID;
        private String sdkVersion;
        private int deviceType;
        private String iosToken;
        private String publishChannel;
        private String net;

        public String getVender() {
            return vender;
        }

        public void setVender(String vender) {
            this.vender = vender;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }

        public String getOsVersion() {
            return osVersion;
        }

        public void setOsVersion(String osVersion) {
            this.osVersion = osVersion;
        }

        public String getDeviceID() {
            return deviceID;
        }

        public void setDeviceID(String deviceID) {
            this.deviceID = deviceID;
        }

        public String getSdkVersion() {
            return sdkVersion;
        }

        public void setSdkVersion(String sdkVersion) {
            this.sdkVersion = sdkVersion;
        }

        public int getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(int deviceType) {
            this.deviceType = deviceType;
        }

        public String getIosToken() {
            return iosToken;
        }

        public void setIosToken(String iosToken) {
            this.iosToken = iosToken;
        }

        public String getPublishChannel() {
            return publishChannel;
        }

        public void setPublishChannel(String publishChannel) {
            this.publishChannel = publishChannel;
        }

        public String getNet() {
            return net;
        }

        public void setNet(String net) {
            this.net = net;
        }
    }
}
