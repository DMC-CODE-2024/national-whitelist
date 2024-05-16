package com.gl.ceir.enums;

public enum Rules {
    VALID_TAC,
    IMEI_NULL,
    IMEI_LENGTH_NATIONAL_WHITELIST,
    IMEI_TEST,
    IMEI_ALPHANUMERIC,
    CUSTOM_CHK,
    TYPE_APPROVED,
    EXISTS_IN_LOCAL_MANUFACTURER_DB;

    public String getRuleName() {
        return this.name();
    }

}
