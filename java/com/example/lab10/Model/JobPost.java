package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobPost {


// id:
// - Must be Generated.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;


//title:
// - Cannot be null.
// - Length must be more than 4 characters.
     @NotEmpty(message = "Title cannot be null")
     @Size(min = 4,message = "Name length must be more than 4 characters.")
     @Column(columnDefinition = "varchar(20)  not null")
     private String title;


//▪ description:
//- Cannot be null.
    @NotEmpty(message = "Description cannot be null")
    @Column(columnDefinition = "varchar(255)  not null")
    private  String description;


 //  ▪ location:
 // - Cannot be null.
    @NotEmpty(message = "Location cannot be null")
    @Column(columnDefinition = "varchar(25)  not null")
    private  String location;



//  ▪ salary:
//  - Cannot be null.
// - Must be a non-negative number.
    @NotNull(message = "Salary cannot be null")
    @Positive
    @Column(columnDefinition = "double not null")
    private Double salary;

    // ▪ postingDate
     @Column(columnDefinition = "Date not null")
    //@Column(nullable = false)
    private LocalDate postingDate;














}
