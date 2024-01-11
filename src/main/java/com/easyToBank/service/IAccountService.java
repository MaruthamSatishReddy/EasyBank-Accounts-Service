package com.easyToBank.service;

import com.easyToBank.dto.CustomerDTO;

public interface IAccountService {
    void createAccount(CustomerDTO customerDto);
    CustomerDTO fetchAccount(String mobileNumber);
    boolean updateAccount(CustomerDTO customerDTO);
}
