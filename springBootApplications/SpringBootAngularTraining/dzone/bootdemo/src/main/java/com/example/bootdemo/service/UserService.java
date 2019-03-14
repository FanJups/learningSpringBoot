package com.example.bootdemo.service;

import java.util.List;

import com.example.bootdemo.dto.UserDto;

public interface UserService {
	 UserDto getUserById(Integer userId);
	 void saveUser(UserDto userDto);
	 List < UserDto > getAllUsers();
}
