package com.example.demo.service;


import com.example.demo.dto.BranchDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Branch;
import com.example.demo.model.User;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.UserRepository;

import java.util.Optional;

public class UserService {
    UserRepository userRepository;
    BranchRepository branchRepository;
    public UserService(UserRepository userRepository, BranchRepository branchRepository) {
        this.userRepository = userRepository;
        this.branchRepository=branchRepository;

    }
    User createUser(UserDto userDto)
    {
        User user=new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setPhoneNumber(userDto.getPhoneNumber());

        userRepository.save(user);
        Branch nearest = new Branch() ;
        nearest = branchRepository.linkUserToBranch(user.getUserId() , nearest.getBranchId());
        user.setBranch(nearest);
        return user ;

    }
    public User getUserDetails(Long userId)
    {
        Optional<User> Optionaluser = userRepository.findById(userId);
        if(!Optionaluser.isPresent())
        {
            throw new RuntimeException("User with ID " + userId + " not found.");
        }
        return Optionaluser.get();
    }

}
