package com.example.APIdemo_1.dto;

import com.example.APIdemo_1.models.User;
import lombok.Data;

@Data
public class UserResponseDTO {
    private User user ;
    private ResponseStatus responseStatus ;
}
