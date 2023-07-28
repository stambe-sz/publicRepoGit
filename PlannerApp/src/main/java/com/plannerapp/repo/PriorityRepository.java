package com.plannerapp.repo;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.enums.PriorityNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriorityRepository extends JpaRepository<Priority,Long> {
    Optional<Priority> findByName(PriorityNameEnum name);
}
