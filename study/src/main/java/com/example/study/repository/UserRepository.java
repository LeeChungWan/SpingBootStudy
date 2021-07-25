package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /* 
     FirstBy : 가장 처음 검색되는 항목 하나 리턴
     OrderByIdDesc : id 순서로 내림차순
     */
    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);
    
}
