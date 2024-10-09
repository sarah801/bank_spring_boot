package com.example.demo.repository;

import com.example.demo.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BranchRepository extends JpaRepository<Branch, Long> {
    Branch findbyCode(String branchCode) ;
    Branch linkUserToBranch(long  userId, long branchId) ;
}
