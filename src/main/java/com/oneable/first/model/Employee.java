package com.oneable.first.model;


import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data

@Document(collection = "employee")
public class Employee {


@Id
private long id;

private String ObjectId;

@NotNull(message="firstname should be not null ")
@NotEmpty
@Length(min=5,max=10,message = "firstName Should at least 5 character")
private String firstName;
@NotNull(message="lastNme should not be null")
private String lastName;
@NotEmpty(message="Dessignation should be Required")
private String designation;

private double sallary;
@Override
public String toString() {
	return "Employee [Id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", designation="
			+ designation + ", sallary=" + sallary + "]";
}


}
