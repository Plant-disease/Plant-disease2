package com.example.plantdiseasedetection.controller.impl;

import com.example.plantdiseasedetection.controller.AttachmentController;
import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AttachmentControllerImpl implements AttachmentController {

    private final AttachmentService attachmentService;

    @Override
    public ApiResult<?> uploadFileToFileSystem(MultipartHttpServletRequest request) {
        return attachmentService.uploadFileToFileSystem(request);
    }

    @Override
    public ApiResult<?> uploadAllFileToFileSystem(MultipartHttpServletRequest request) {
        return attachmentService.uploadAllFileToFileSystem(request);
    }

//    @Override
//    public ApiResult<?> uploadFileToDB(MultipartHttpServletRequest request) {
//        return attachmentService.uploadFileToDB(request);
//    }
//
//    @Override
//    public ApiResult<?> downloadFileFromDB(UUID id, HttpServletResponse response) {
//        return attachmentService.downloadFileFromDB(id, response);
//    }

    @Override
    public ApiResult<?> downloadFileFromSystem(UUID id, HttpServletResponse response) {
        return attachmentService.downloadFileFromSystem(id, response);
    }
}

