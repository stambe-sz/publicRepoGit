package com.resellerapp.service.impl;

import com.resellerapp.enums.ConditionEnum;
import com.resellerapp.models.entity.Condition;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.service.ConditionService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConditionServiceImpl implements ConditionService {
    private final ConditionRepository conditionRepository;

    public ConditionServiceImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void initConditions() {
        if (conditionRepository.count() != 0){
            return;
        }
        Arrays.stream(ConditionEnum.values())
                .forEach(conditionEnum -> {
                    Condition condition = new Condition();
                    condition.setName(conditionEnum);

                    switch (conditionEnum){
                        case EXCELLENT -> condition.setDescription("In perfect condition");
                        case GOOD -> condition.setDescription("Some signs of wear and tear or minor defects");
                        case ACCEPTABLE -> condition.setDescription("The item is fairly worn but continues to function properly");
                    }

                    conditionRepository.save(condition);
                });

    }

    @Override
    public Condition findByConditionEnum(ConditionEnum conditionEnum) {
        return conditionRepository
                .findByName(conditionEnum)
                .orElse(null);
    }
}
