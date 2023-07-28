package com.plannerapp.repo;

import com.plannerapp.model.binding.AllAvailableTasksBindingModel;
import com.plannerapp.model.binding.UserAssignedTasksBindingModel;
import com.plannerapp.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query("SELECT new com.plannerapp.model.binding.UserAssignedTasksBindingModel(t.id,t.description,t.dueDate,t.priority.name) FROM Task t WHERE t.user.id = :id")
    List<UserAssignedTasksBindingModel> findAllTasksByUserId(Long id);

    @Query("SELECT new com.plannerapp.model.binding.AllAvailableTasksBindingModel(t.id,) FROM Task t ")
    List<AllAvailableTasksBindingModel> findAllAvailableTasks(Long id);
}
