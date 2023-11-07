package com.gl.ceir.dto;

import java.util.List;

public class RuleEngineDto<T, C> {
    List<T> nationalWhitelistAccepted;
    List<C> exceptionList;

    public RuleEngineDto() {
    }

    public RuleEngineDto(List<T> nationalWhitelistAccepted, List<C> exceptionList) {
        this.nationalWhitelistAccepted = nationalWhitelistAccepted;
        this.exceptionList = exceptionList;
    }

    public List<T> getNationalWhitelistAccepted() {
        return nationalWhitelistAccepted;
    }

    public void setNationalWhitelistAccepted(List<T> nationalWhitelistAccepted) {
        this.nationalWhitelistAccepted = nationalWhitelistAccepted;
    }

    public List<C> getExceptionList() {
        return exceptionList;
    }

    public void setExceptionList(List<C> exceptionList) {
        this.exceptionList = exceptionList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RuleEngineDto{");
        sb.append("nationalWhitelistAccepted=").append(nationalWhitelistAccepted);
        sb.append(", exceptionList=").append(exceptionList);
        sb.append('}');
        return sb.toString();
    }
}
