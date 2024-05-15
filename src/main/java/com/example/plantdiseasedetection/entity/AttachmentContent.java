package com.example.plantdiseasedetection.entity;

import com.example.plantdiseasedetection.entity.templete.AbsUUIDUserAuditEntity;
import com.example.plantdiseasedetection.utils.TableNameConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = TableNameConstant.ATTACHMENT_CONTENT)
public class AttachmentContent extends AbsUUIDUserAuditEntity {

    private byte[] content;//asosiy content

    @OneToOne
    private Attachment attachment;

}

