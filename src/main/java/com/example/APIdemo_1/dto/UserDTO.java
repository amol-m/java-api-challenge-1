package com.example.APIdemo_1.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserDTO {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id ;

 private String name;
 private String status;

}
