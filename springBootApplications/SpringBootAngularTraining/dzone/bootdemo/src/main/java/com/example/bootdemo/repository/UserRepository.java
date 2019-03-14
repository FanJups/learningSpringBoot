package com.example.bootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bootdemo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}
