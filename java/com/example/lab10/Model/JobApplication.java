package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobApplication {



// id:
//  - Must be Generated.
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private Integer Id;


//userId:
// - Cannot be null.
  @NotNull(message = "userId cannot be null")
  @Column(columnDefinition = "int not null")
  private Integer userId;



//  jobPostId:
//  - Cannot be null
    @NotNull(message = "jobPostId cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer jobPostId;






}
