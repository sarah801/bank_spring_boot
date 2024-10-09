package com.example.demo.service;

import com.example.demo.dto.BranchDto;
import com.example.demo.model.Branch;
import com.example.demo.model.User;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class BranchService {
BranchRepository branchRepository ;
UserRepository userRepository ;
public BranchService(BranchRepository branchRepository, UserRepository userRepository)
{
    this.userRepository = userRepository ;
    this.branchRepository = branchRepository ;
}
Branch createBranch(BranchDto branchDto)
{
Branch branch = new Branch() ;
branch.setBranchCode(branchDto.getBranchCode());
branch.setBranchName(branchDto.getBranchName());
branch.setAddress(branchDto.getAddress());
branchRepository.save(branch) ;
return branch ;
}
Branch getBranchDetails(Long branchId)
{
    Optional<Branch> Optionalbranch = branchRepository.findById(branchId);
    if(!Optionalbranch.isPresent())
    {
        throw new RuntimeException("branch not found") ;

    }
    return Optionalbranch.get() ;
}
public List<User>  getAllUsersInBranch(Long branchId)
{
    Branch branch = branchRepository.findById(branchId)
            .orElseThrow(() -> new RuntimeException("Branch with ID " + branchId + " not found."));
    List<User> usersList = userRepository.findByBranch(branch);
 return usersList ;
}
}
