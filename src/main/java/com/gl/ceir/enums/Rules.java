package com.gl.ceir.enums;

public enum Rules {
    VALID_TAC,
    IMEI_NULL,
    IMEI_LENGTH_NATIONAL_WHITELIST,
    IMEI_TEST,
    IMEI_ALPHANUMERIC;

    public String getRuleName() {
        return this.name();
    }

}
