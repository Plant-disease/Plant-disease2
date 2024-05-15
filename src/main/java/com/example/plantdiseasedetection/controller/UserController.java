package com.example.plantdiseasedetection.controller;

import com.example.plantdiseasedetection.aop.CurrentUser;
import com.example.plantdiseasedetection.entity.User;
import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.ChangeRoleDTO;
import com.example.plantdiseasedetection.payload.UserDTO;
import com.example.plantdiseasedetection.utils.RestConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping(UserController.AUTH_CONTROLLER)
public interface UserController {
    String AUTH_CONTROLLER = RestConstants.BASE_PATH_V1 + "/user";

    String ME = "/me";
    String GET_ALL_USERS = "/get-all";
    String GET_ALL_ROLE = "/get-all-roles";
    String CHANGE_USER_ROLE = "/change-user-role";


    @GetMapping(ME)
    ApiResult<UserDTO> me(@CurrentUser User user);

    @GetMapping(GET_ALL_USERS)
    ApiResult<?> getAllUsers();

    @GetMapping(GET_ALL_ROLE)
    ApiResult<?> getAllRole();

    @PutMapping(CHANGE_USER_ROLE)
    ApiResult<?> changeUserRole(@Valid @RequestBody ChangeRoleDTO changeRoleDTO);
}
