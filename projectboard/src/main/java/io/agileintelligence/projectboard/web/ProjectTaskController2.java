package io.agileintelligence.projectboard.web;


import io.agileintelligence.projectboard.domain.ProjectTask2;
import io.agileintelligence.projectboard.service.ProjectTaskService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/board2")
@CrossOrigin
public class ProjectTaskController2 {

    @Autowired
    private ProjectTaskService2 projectTaskService;

    @PostMapping("/2")
    public ResponseEntity<?> addPTToBoard(@Valid @RequestBody ProjectTask2 projectTask, BindingResult result){

        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        ProjectTask2 newPT = projectTaskService.saveOrUpdateProjectTask(projectTask);

        return new ResponseEntity<ProjectTask2>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("/all2")
    public Iterable<ProjectTask2> getAllPTs(){
        return projectTaskService.findAll();
    }

    @GetMapping("2/{pt_id}")
    public ResponseEntity<?> getPTById(@PathVariable Long pt_id){
        ProjectTask2 projectTask = projectTaskService.findById(pt_id);
        return new ResponseEntity<ProjectTask2>(projectTask, HttpStatus.OK);
    }

    @DeleteMapping("2/{pt_id}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable Long pt_id){
        projectTaskService.delete(pt_id);

        return new ResponseEntity<String>("Project Task deleted", HttpStatus.OK);
    }

}
