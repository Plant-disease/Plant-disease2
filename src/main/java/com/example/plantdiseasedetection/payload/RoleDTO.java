package com.example.plantdiseasedetection.payload;

import com.example.plantdiseasedetection.enums.Permission;
import com.example.plantdiseasedetection.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDTO implements Serializable {
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private RoleType type;

    @NotEmpty
    private Set<Permission> permissions;
}
