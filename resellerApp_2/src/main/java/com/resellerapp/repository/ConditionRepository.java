package com.resellerapp.repository;

import com.resellerapp.enums.ConditionEnum;
import com.resellerapp.models.entity.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, UUID> {

    Optional<Condition> findByName(ConditionEnum name);
}
