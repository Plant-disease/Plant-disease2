package com.example.plantdiseasedetection.controller.impl;

import com.example.plantdiseasedetection.aop.CheckPermission;
import com.example.plantdiseasedetection.controller.UserController;
import com.example.plantdiseasedetection.entity.User;
import com.example.plantdiseasedetection.enums.Permission;
import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.ChangeRoleDTO;
import com.example.plantdiseasedetection.payload.UserDTO;
import com.example.plantdiseasedetection.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    public ApiResult<UserDTO> me(User user) {
        return userService.me(user);
    }

    @CheckPermission(permissions = {Permission.GET_ALL_USERS})
    @Override
    public ApiResult<?> getAllUsers() {
        return userService.getAllUsers();

    }

    @CheckPermission(permissions = {Permission.GET_ALL_ROLES})
    @Override
    public ApiResult<?> getAllRole() {
        return userService.getAllRole();
    }

    @CheckPermission(permissions = {Permission.CHANGE_USER_ROLE})
    @Override
    public ApiResult<?> changeUserRole(ChangeRoleDTO changeRoleDTO) {
        return userService.changeUserRole(changeRoleDTO);
    }
}
