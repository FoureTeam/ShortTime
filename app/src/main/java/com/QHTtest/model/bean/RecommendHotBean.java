package com.QHTtest.model.bean;

import java.util.List;

/**
 * Title:
 * Thinking:
 * 作者：邹诗惠 on 2017/8/1 11:07
 */

public class RecommendHotBean {

    /**
     * code : 200
     * resource : [{"badKey":"0o8F571ssoM7ss70287183oo75s82s6o","badNum":0,"commentKey":"0o8F571ssoM7ss70287183oo75s82s6o","commentList":[],"commentNum":0,"content":"我擦 大没了","description":"","dictionaryValue":"2","forwardKey":"787777Ms4F07607f70o05s5Ms352fF43","forwardNum":0,"id":1,"name":"","niceKey":"787777Ms4F07607f70o05s5Ms352fF43","niceNum":546,"pictureSrc":"","playTimeKey":"","playtimes":"","src":"","uptime":"2017-07-20 21:56:33.0","user":{"userId":1,"userName":"aa","userPassword":"aaa","userPhone":"123456","userSex":"男"},"userId":1},{"badKey":"0o8F571ssoM7ss70287183o","badNum":0,"commentKey":"0o8F571ssoM7ss70287183oo","commentList":[],"commentNum":0,"content":"我擦 大没了","description":"","dictionaryValue":"2","forwardKey":"787777Ms4F07607","forwardNum":0,"id":2,"name":"","niceKey":"787777Ms4F07607f70o05s5Ms","niceNum":756,"pictureSrc":"","playTimeKey":"","playtimes":"","src":"","uptime":"2017-07-15 22:25:17.0","user":{"userId":1,"userName":"aa","userPassword":"aaa","userPhone":"123456","userSex":"男"},"userId":1}]
     */

    private String code;
    private List<ResourceBean> resource;

    @Override
    public String toString() {
        return "RecommendHotBean{" +
                "code='" + code + '\'' +
                ", resource=" + resource +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ResourceBean> getResource() {
        return resource;
    }

    public void setResource(List<ResourceBean> resource) {
        this.resource = resource;
    }

    public static class ResourceBean {
        /**
         * badKey : 0o8F571ssoM7ss70287183oo75s82s6o
         * badNum : 0
         * commentKey : 0o8F571ssoM7ss70287183oo75s82s6o
         * commentList : []
         * commentNum : 0
         * content : 我擦 大没了
         * description :
         * dictionaryValue : 2
         * forwardKey : 787777Ms4F07607f70o05s5Ms352fF43
         * forwardNum : 0
         * id : 1
         * name :
         * niceKey : 787777Ms4F07607f70o05s5Ms352fF43
         * niceNum : 546
         * pictureSrc :
         * playTimeKey :
         * playtimes :
         * src :
         * uptime : 2017-07-20 21:56:33.0
         * user : {"userId":1,"userName":"aa","userPassword":"aaa","userPhone":"123456","userSex":"男"}
         * userId : 1
         */

        private String badKey;
        private int badNum;
        private String commentKey;
        private int commentNum;
        private String content;
        private String description;
        private String dictionaryValue;
        private String forwardKey;
        private int forwardNum;
        private int id;
        private String name;
        private String niceKey;
        private int niceNum;
        private String pictureSrc;
        private String playTimeKey;
        private String playtimes;
        private String src;
        private String uptime;
        private UserBean user;
        private int userId;
        private List<?> commentList;

        @Override
        public String toString() {
            return "ResourceBean{" +
                    "badKey='" + badKey + '\'' +
                    ", badNum=" + badNum +
                    ", commentKey='" + commentKey + '\'' +
                    ", commentNum=" + commentNum +
                    ", content='" + content + '\'' +
                    ", description='" + description + '\'' +
                    ", dictionaryValue='" + dictionaryValue + '\'' +
                    ", forwardKey='" + forwardKey + '\'' +
                    ", forwardNum=" + forwardNum +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", niceKey='" + niceKey + '\'' +
                    ", niceNum=" + niceNum +
                    ", pictureSrc='" + pictureSrc + '\'' +
                    ", playTimeKey='" + playTimeKey + '\'' +
                    ", playtimes='" + playtimes + '\'' +
                    ", src='" + src + '\'' +
                    ", uptime='" + uptime + '\'' +
                    ", user=" + user +
                    ", userId=" + userId +
                    ", commentList=" + commentList +
                    '}';
        }

        public String getBadKey() {
            return badKey;
        }

        public void setBadKey(String badKey) {
            this.badKey = badKey;
        }

        public int getBadNum() {
            return badNum;
        }

        public void setBadNum(int badNum) {
            this.badNum = badNum;
        }

        public String getCommentKey() {
            return commentKey;
        }

        public void setCommentKey(String commentKey) {
            this.commentKey = commentKey;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDictionaryValue() {
            return dictionaryValue;
        }

        public void setDictionaryValue(String dictionaryValue) {
            this.dictionaryValue = dictionaryValue;
        }

        public String getForwardKey() {
            return forwardKey;
        }

        public void setForwardKey(String forwardKey) {
            this.forwardKey = forwardKey;
        }

        public int getForwardNum() {
            return forwardNum;
        }

        public void setForwardNum(int forwardNum) {
            this.forwardNum = forwardNum;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNiceKey() {
            return niceKey;
        }

        public void setNiceKey(String niceKey) {
            this.niceKey = niceKey;
        }

        public int getNiceNum() {
            return niceNum;
        }

        public void setNiceNum(int niceNum) {
            this.niceNum = niceNum;
        }

        public String getPictureSrc() {
            return pictureSrc;
        }

        public void setPictureSrc(String pictureSrc) {
            this.pictureSrc = pictureSrc;
        }

        public String getPlayTimeKey() {
            return playTimeKey;
        }

        public void setPlayTimeKey(String playTimeKey) {
            this.playTimeKey = playTimeKey;
        }

        public String getPlaytimes() {
            return playtimes;
        }

        public void setPlaytimes(String playtimes) {
            this.playtimes = playtimes;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getUptime() {
            return uptime;
        }

        public void setUptime(String uptime) {
            this.uptime = uptime;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public List<?> getCommentList() {
            return commentList;
        }

        public void setCommentList(List<?> commentList) {
            this.commentList = commentList;
        }

        public static class UserBean {
            /**
             * userId : 1
             * userName : aa
             * userPassword : aaa
             * userPhone : 123456
             * userSex : 男
             */

            private int userId;
            private String userName;
            private String userPassword;
            private String userPhone;
            private String userSex;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserPassword() {
                return userPassword;
            }

            public void setUserPassword(String userPassword) {
                this.userPassword = userPassword;
            }

            public String getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(String userPhone) {
                this.userPhone = userPhone;
            }

            public String getUserSex() {
                return userSex;
            }

            public void setUserSex(String userSex) {
                this.userSex = userSex;
            }
        }
    }
}
