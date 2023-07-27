package com.plannerapp.repo;

import com.plannerapp.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query("SELECT new com.plannerapp.model.binding.UserAssignedTasksBindingModel(t.id,t.description,t.dueDate,t.priority.name) FROM Task t WHERE t.user.id = :id")
    void findAllTasksByUserId(Long id);
}
