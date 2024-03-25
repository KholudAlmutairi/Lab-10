package com.example.lab10.Service;

import com.example.lab10.Model.JobApplication;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Model.User;
import com.example.lab10.Repository.JobApplicationRepository;
import com.example.lab10.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;


    //9. Get all Job Applications: Retrieves a list of all Job Application.
    //10. Apply For Job: Adds a new job application to the system.
    //11. Withdraw Job Application: Deletes a job application from the system.
    //Note: 12 Verify that the job application exists



    public List<JobApplication> getAllJobApplications(){
        return  jobApplicationRepository.findAll();
    }

    public void addJobApplication(JobApplication jobApplication){
        jobApplicationRepository.save(jobApplication);
    }




    public Boolean deletejobApplication(Integer id){
        if (jobApplicationRepository.existsById(id)) {
            jobApplicationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    public Boolean deletejobApplication2(Integer id){
        JobApplication j=jobApplicationRepository.getById(id);
        if(j==null){
            return false;
        }
        jobApplicationRepository.delete(j);
        return true;
    }



















}
