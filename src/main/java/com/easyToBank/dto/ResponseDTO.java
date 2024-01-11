package com.easyToBank.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
    @Schema(description = "Status Code")
    private String statusCode;

    @Schema(description = "Status Message ")
    private String statusMsg;
}
