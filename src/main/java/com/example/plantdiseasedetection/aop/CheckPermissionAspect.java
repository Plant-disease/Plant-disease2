package com.example.plantdiseasedetection.aop;

import com.example.plantdiseasedetection.entity.User;
import com.example.plantdiseasedetection.exception.RestException;
import com.example.plantdiseasedetection.service.impl.UserServiceImpl;
import com.example.plantdiseasedetection.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
@RequiredArgsConstructor
public class CheckPermissionAspect {
    private final UserServiceImpl userServiceImpl;

    @Before(value = "@annotation(checkPermission)")
    public void checkRoleExecutor(CheckPermission checkPermission) {
        User user = CommonUtils.getUserFromSecurityContext();
        if (Objects.isNull(user))
            throw RestException.noAuthority();

        userServiceImpl.checkPermission(Arrays.asList(checkPermission.permissions()), user);
    }
}
