package com.teamgold.goldenharvestsales.common.infra.file.domain.dto;


import com.teamgold.goldenharvestsales.common.infra.file.domain.FileContentType;

public record FileUploadResponse(
        Long fileId,
        String fileUrl,
        FileContentType contentType
) {}
