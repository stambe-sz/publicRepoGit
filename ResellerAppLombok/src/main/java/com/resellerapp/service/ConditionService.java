package com.resellerapp.service;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.enums.ConditionNameEnum;
import com.resellerapp.repository.ConditionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConditionService {

    private final ConditionRepository conditionRepository;
    private final ModelMapper modelMapper;

    public ConditionService(ConditionRepository conditionRepository, ModelMapper modelMapper) {
        this.conditionRepository = conditionRepository;
        this.modelMapper = modelMapper;
    }

    public void initConditions() {
        if(conditionRepository.count() != 0){
            return;
        }
        Arrays.stream(ConditionNameEnum.values())
                .forEach(conditionNameEnum -> {
                    Condition condition = new Condition();
                    condition.setConditionName(conditionNameEnum);
                    switch (conditionNameEnum){
                        case EXCELLENT -> condition.setDescription("In perfect condition");
                        case GOOD -> condition.setDescription("Some signs of wear and tear or minor defects");
                        case ACCEPTABLE -> condition.setDescription("The item is fairly worn but continues to function properly");
                    }
                    conditionRepository.save(condition);
                });

    }
}
