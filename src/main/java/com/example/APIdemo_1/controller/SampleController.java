package com.example.APIdemo_1.controller;

import com.example.APIdemo_1.dto.ResponseStatus;
import com.example.APIdemo_1.dto.UserResponseDTO;
import com.example.APIdemo_1.dto.UserDTO;
import com.example.APIdemo_1.models.User;
import com.example.APIdemo_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class SampleController {

    private UserService userservice ;


    @Autowired
    public void UserController(UserService userservice) {
        this.userservice = userservice;
    }

    @GetMapping("/greet")
    public String greet() {
        return "Hello World" ;
    }

    @GetMapping("/greetname/{name}")
    public String greetname(@PathVariable("name") String name) {
        return "Hello, " + name ;
    }

    @PostMapping()
    public UserResponseDTO createUser(@RequestBody UserDTO requestdto ) {

        String name = requestdto.getName();
        String status = requestdto.getStatus() ;
        int id  = requestdto.getId() ;


        UserResponseDTO responseDTO = new UserResponseDTO() ;

        try {
            User User = this.userservice.registeruser( id , name, status);
            responseDTO.setUser(User);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;

    }
}

