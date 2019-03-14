package com.example.bootdemo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bootdemo.converter.UserConverter;
import com.example.bootdemo.dto.UserDto;
import com.example.bootdemo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
 @Autowired
 UserRepository userRepository;
 @Override
 public UserDto getUserById(Integer userId) {
  return UserConverter.entityToDto(userRepository.getOne(userId));
 }
 @Override
 public void saveUser(UserDto userDto) {
  userRepository.save(UserConverter.dtoToEntity(userDto));
 }
 @Override
 public List < UserDto > getAllUsers() {
  return userRepository.findAll().stream().map(UserConverter::entityToDto).collect(Collectors.toList());
 }
}
