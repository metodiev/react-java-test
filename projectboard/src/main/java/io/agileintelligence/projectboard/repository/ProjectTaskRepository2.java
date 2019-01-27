package io.agileintelligence.projectboard.repository;


import io.agileintelligence.projectboard.domain.ProjectTask2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository2 extends CrudRepository<ProjectTask2, Long> {

    ProjectTask2 getById(Long id);
}
