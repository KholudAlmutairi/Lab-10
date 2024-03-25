package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.JobApplication;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobApplication")
@RequiredArgsConstructor

public class JobApplicationController {

    private final JobApplicationService jobApplicationService;



    @GetMapping("/get")
    public ResponseEntity getAllJobApplications(){
        return ResponseEntity.status(200).body( jobApplicationService.getAllJobApplications());
    }

    @PostMapping("/add")
    public ResponseEntity addJobApplication(@RequestBody @Valid JobApplication jobApplication, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);
        }
        jobApplicationService.addJobApplication(jobApplication);
        return ResponseEntity.status(200).body(new ApiResponse("Job Application Added"));

    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobApplication(@PathVariable Integer id){

        Boolean idDeleted=jobApplicationService.deletejobApplication(id);
        if(idDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Job Application deleted!"));
        }

        return ResponseEntity.status(400).body("Job Application not found!");
    }



}
