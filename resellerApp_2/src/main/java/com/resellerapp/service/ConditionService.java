package com.resellerapp.service;

import com.resellerapp.enums.ConditionEnum;
import com.resellerapp.models.entity.Condition;

public interface ConditionService {
    void initConditions();

    Condition findByConditionEnum(ConditionEnum conditionEnum);
}
