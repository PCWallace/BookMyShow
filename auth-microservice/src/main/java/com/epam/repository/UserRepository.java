package com.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.MyUsers;

@Repository
public interface UserRepository extends JpaRepository<MyUsers, String>{
public MyUsers findByUsername(String username);

}
