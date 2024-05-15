package com.example.plantdiseasedetection.service.init;

import com.example.plantdiseasedetection.entity.Role;
import com.example.plantdiseasedetection.entity.User;
import com.example.plantdiseasedetection.enums.Permission;
import com.example.plantdiseasedetection.enums.RoleType;
import com.example.plantdiseasedetection.repository.RoleRepository;
import com.example.plantdiseasedetection.repository.UserRepository;
import com.example.plantdiseasedetection.utils.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class InitService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void createRoleByRoleType() {
        List<Role> roleList = new ArrayList<>();
        try {
            for (RoleType type : RoleType.values()) {
                    Set<Permission> permissionSet = Stream.of(Permission.values()).filter(permission -> permission.getRoleTypes().contains(type)).collect(Collectors.toSet());
                    roleList.add(new Role(type.name(), type, permissionSet));
            }
            roleRepository.saveAll(roleList);

            Optional<Role> adminRole = roleRepository.findByType(RoleType.SUPER_ADMIN);
            if (adminRole.isPresent()) {
                User admin = new User("Admin", RestConstants.ADMIN_EMAIL,RestConstants.ADMIN_EMAIL, passwordEncoder.encode("admin"), adminRole.get(), true,true);
                userRepository.save(admin);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
