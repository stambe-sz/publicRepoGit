package com.plannerapp.service;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.enums.PriorityNameEnum;
import com.plannerapp.repo.PriorityRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PriorityService {
    private final PriorityRepository priorityRepository;


    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }


    public void initPriorities() {
        if (priorityRepository.count() !=0){
            return;
        }

        Arrays.stream(PriorityNameEnum.values())
                .forEach(prior -> {
                    Priority priority = new Priority();
                    priority.setName(prior);
                    switch (prior){
                        case URGENT -> priority.setDescription("An urgent problem that blocks the system use until the issue is resolved.");
                        case IMPORTANT -> priority.setDescription("A core functionality that your product is explicitly supposed to perform is compromised.");
                        case LOW -> priority.setDescription("Should be fixed if time permits but can be postponed.");
                    }
                    priorityRepository.save(priority);
                });
    }


    public Priority findPriorityNameEnum(PriorityNameEnum priority) {
        return priorityRepository
                .findByName(priority).orElse(null);
    }
}
