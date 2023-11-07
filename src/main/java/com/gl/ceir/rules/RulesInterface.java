package com.gl.ceir.rules;

import com.gl.ceir.dto.RuleEngineDto;
import com.gl.ceir.model.app.*;

public interface RulesInterface {

    public RuleEngineDto<ActiveUniqueImei, ExceptionList> validateActiveUniqueImei(RuleEngineDto<ActiveUniqueImei, ExceptionList> ruleEngineDto);
    public RuleEngineDto<ActiveImeiWithDifferentMsisdn, ExceptionList> validateActiveImeiWithDifferentMsisdn(RuleEngineDto<ActiveImeiWithDifferentMsisdn, ExceptionList> ruleEngineDto);
    RuleEngineDto<ActiveUniqueForeignImei, ForeignExceptionList> validateActiveUniqueForeignImei(RuleEngineDto<ActiveUniqueForeignImei, ForeignExceptionList> ruleEngineDto);
    public RuleEngineDto<ActiveForeignImeiWithDifferentMsisdn, ForeignExceptionList> validateActiveForeignImeiWithDifferentMsisdn(RuleEngineDto<ActiveForeignImeiWithDifferentMsisdn, ForeignExceptionList> ruleEngineDto);

}
