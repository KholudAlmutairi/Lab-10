package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;
    //Must be Generated.


     @NotEmpty(message = "Name cannot be null")
     @Size(min = 4,message = "Name length must be more than 4 characters.")
     //@Column(columnDefinition = "varchar(10) check(length(name)>4) not null")
     @Column(columnDefinition = "varchar(10)  not null")
     @Pattern(regexp = "^[a-zA-Z]+$",message = " Name must contain only characters (no numbers)")
     private String name;
    //- Cannot be null.
    //- Length must be more than 4 characters.
    //- Must contain only characters (no numbers).


      @Email
      @Column(columnDefinition = "varchar(40) unique")
      private String email;
    // Must be a valid email format.
    // Must be unique

     @NotEmpty(message = "Password cannot be null")
     @Column(columnDefinition = "varchar(40) not null")
    private String password;
   //- Cannot be null.




   @NotNull(message = "Age cannot be null")
   @Positive
   @Min(22)
   @Column(columnDefinition = "int not null")
   private Integer age;

//   -Cannot be null.
//  - Must be a number.
//  - Must be more than 21.



      @NotEmpty(message = "Role cannot be null")
      @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$", message = "Must be either 'JOB_SEEKER' or 'EMPLOYER'")
      //@Column(columnDefinition = "varchar(10) not null check(role='JOB_SEEKER' or category='EMPLOYER')")
      @Column(columnDefinition = "varchar(10) not null")

    private String role;

//    Cannot be null.
//            - Must be either "JOB_SEEKER" or "EMPLOYER" only.





}
