package com.example.plantdiseasedetection.entity;

import com.example.plantdiseasedetection.entity.templete.AbsLongEntity;
import com.example.plantdiseasedetection.enums.Permission;
import com.example.plantdiseasedetection.enums.RoleType;
import com.example.plantdiseasedetection.utils.ColumnKey;
import com.example.plantdiseasedetection.utils.TableNameConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = TableNameConstant.ROLE)
public class Role extends AbsLongEntity {

    @Column(nullable = false, unique = true, name = ColumnKey.NAME)
    private String name;

    @Column(name = ColumnKey.DESCRIPTION,length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    private RoleType type;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Permission> permissions;

    public Role(String name, RoleType type, Set<Permission> permissions) {
        this.name = name;
        this.type = type;
        this.permissions = permissions;
    }
}
