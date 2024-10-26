package com.java.Spring.Boot.Project.with.Web.and.service;

import com.java.Spring.Boot.Project.with.Web.and.dto.UserReigtserDto;
import com.java.Spring.Boot.Project.with.Web.and.entity.UsersInfo;
import com.java.Spring.Boot.Project.with.Web.and.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public String userRegistration(UserReigtserDto userReigtserDto) {

        // convert dto instance  to entity object
        UsersInfo user = new UsersInfo();
        user.setContact(userReigtserDto.getContact());
        user.setEmailId(userReigtserDto.getEmailId());
        user.setName(userReigtserDto.getName());
        user.setPassword(userReigtserDto.getPassword());

        repository.save(user);

        return "User Registration Successfull.";
    }


    public String validateUser(String emailId, String password) {

        // Verify in data base
        List<UsersInfo> users = repository.findByEmailIdAndPassword(emailId, password);

        if (users.size() == 0) {
            return "Invalid Credentilas. Please Try again";
        } else {
            return "Welcome to FaceBook, " + emailId;
        }

    }

}
