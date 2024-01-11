package com.easyToBank.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@Schema(
        name = "Error Response",
        description = "Schema to hold Error Response Information"
)
public class ErrorResponseDTO {
    @Schema( description = "API Path Invoked By Client")
    private String apiPath;

    @Schema(description = "Error Code")
    private HttpStatus errorCode;

    @Schema(description = "Error Message")
    private String errorMessage;

    @Schema( description = "Time representing when the error happened")
    private LocalDateTime errorTime;
}
