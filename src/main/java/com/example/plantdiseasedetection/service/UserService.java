package com.example.plantdiseasedetection.service;


import com.example.plantdiseasedetection.entity.User;
import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.ChangeRoleDTO;
import com.example.plantdiseasedetection.payload.UserDTO;

public interface UserService {

    ApiResult<UserDTO> me(User user);

    ApiResult<?> getAllUsers();

    ApiResult<?> changeUserRole(ChangeRoleDTO changeRoleDTO);

    ApiResult<?> getAllRole();
}
