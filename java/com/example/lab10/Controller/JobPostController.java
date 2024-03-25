package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobPost")
@RequiredArgsConstructor
public class JobPostController {


    private final JobPostService jobPostService;
    @GetMapping("/get")
    public ResponseEntity getAllJobPosts(){
        return ResponseEntity.status(200).body(jobPostService.getAllJobPosts());
    }

    @PostMapping("/add")
    public ResponseEntity addJobPosts(@RequestBody @Valid JobPost jobPost, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);
        }
        jobPostService.addJobPosts(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("Job Post Added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updatejobPost(@PathVariable Integer id, @RequestBody @Valid JobPost jobPost , Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);

        }

        Boolean isUpdated =jobPostService.updateJobPosts(id,jobPost);

        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse( " jobPost updated"));

        }

        return ResponseEntity.status(400).body("jobPost not found!");

    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletejobPost(@PathVariable Integer id){

        Boolean idDeleted=jobPostService.deleteJobPosts(id);
        if(idDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("JobPost deleted!"));
        }
        return ResponseEntity.status(400).body("JobPost not found!");
    }











}
