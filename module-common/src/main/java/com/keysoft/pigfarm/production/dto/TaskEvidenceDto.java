package com.keysoft.pigfarm.production.dto;

import lombok.Data;

@Data
public class TaskEvidenceDto {
    private String photoUrl;
    private String fileType;
    private String fileName;
    private Long fileSize;
}
