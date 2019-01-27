package io.agileintelligence.projectboard.service;


import io.agileintelligence.projectboard.domain.ProjectTask2;
import io.agileintelligence.projectboard.repository.ProjectTaskRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService2 {

    @Autowired
    private ProjectTaskRepository2 projectTaskRepository;

    public ProjectTask2 saveOrUpdateProjectTask(ProjectTask2 projectTask){

        if(projectTask.getStatus()==null || projectTask.getStatus()==""){
            projectTask.setStatus("TO_DO");
        }

        return projectTaskRepository.save(projectTask);
    }


    public Iterable<ProjectTask2> findAll(){
        return projectTaskRepository.findAll();
    }

    public ProjectTask2 findById(Long id){
        return projectTaskRepository.getById(id);
    }

    public void delete(Long id){
        ProjectTask2 projectTask = findById(id);
        projectTaskRepository.delete(projectTask);
    }
}
