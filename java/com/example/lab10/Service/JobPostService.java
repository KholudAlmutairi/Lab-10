package com.example.lab10.Service;

import com.example.lab10.Model.JobPost;
import com.example.lab10.Model.User;
import com.example.lab10.Repository.JobPostRepository;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository;

   //5.Get all JobPosts: Retrieves a list of all Job Posts.
   //6.Add a new JobPost: Adds a new job post to the system.
   //7.Update a JobPost: Updates an existing job post ’s information.
   //8.Delete a JobPost: Deletes a job post from the system
   //Note: Verify that the job post exists


    public List<JobPost> getAllJobPosts(){
        return jobPostRepository.findAll();
    }

    public void addJobPosts(JobPost jobPost){
        jobPostRepository.save(jobPost);
    }


    public Boolean updateJobPosts(Integer id,JobPost jobPost){
        if(jobPostRepository.existsById(id)){


        JobPost j=jobPostRepository.getById(id);
        j.setTitle(jobPost.getTitle());
        j.setDescription(jobPost.getDescription());
        j.setLocation(jobPost.getLocation());
        j.setSalary(jobPost.getSalary());
        j.setPostingDate(jobPost.getPostingDate());
        jobPostRepository.save(j);
            return true;
        }else {
            return false;
        }
    }

    public Boolean deleteJobPosts(Integer id){
        if(jobPostRepository.existsById(id)){
            JobPost jobPost= jobPostRepository.getById(id);
            jobPostRepository.delete(jobPost);
            return true;
        }else {
            return false;
        }

    }








}
