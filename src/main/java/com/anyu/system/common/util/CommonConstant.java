package com.anyu.system.common.util;

public interface CommonConstant {

    int ADMIN_ALIVE_TIME = 3600 * 24;

    enum EmplStatus{
        SERVICE(0,"任职"),
        DIMISSION(1, "离职"),
        OVERDO(2, "已删除");

        private final int code;
        private final String msg;
        EmplStatus(int code, String mgs) {
            this.code = code;
            this.msg = mgs;
        }


        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }
    }

    enum DeptStatus{
        SERVICE(0,"存在"),
        ABANDON(1, "废弃"),
        DEL(2, "已删除");

        private final int code;
        private final String msg;
        DeptStatus(int code, String mgs) {
            this.code = code;
            this.msg = mgs;
        }


        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }
    }
}
