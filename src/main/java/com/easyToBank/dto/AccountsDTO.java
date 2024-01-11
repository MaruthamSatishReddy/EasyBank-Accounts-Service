package com.easyToBank.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Schema(name = "Accounts",description = "Schema to hold Account Information")
@NotEmpty(message = "Account Number can not be Null or Empty")
public class AccountsDTO {
    private Long accountNumber;
    @NotEmpty(message = "Account Type can not be Null or Empty")
    @Schema(description = "Account Type of Easy Bank",example = "Savings")
    private String accountType;
    @NotEmpty(message = "Account Number can not be Null or Empty")
    @Schema(description = "Branch Address Cannot be Null or Empty",example = "Bangalore ElectronCity Phase-2")
    private String branchAddress;
}
