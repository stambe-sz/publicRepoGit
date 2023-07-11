package com.resellerapp.service;

import com.resellerapp.repository.ConditionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
        
    }
}
