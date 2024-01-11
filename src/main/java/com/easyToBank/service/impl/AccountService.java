package com.easyToBank.service.impl;

import com.easyToBank.constants.AccountConstants;
import com.easyToBank.dto.AccountsDTO;
import com.easyToBank.dto.CustomerDTO;
import com.easyToBank.entity.Accounts;
import com.easyToBank.entity.Customer;
import com.easyToBank.exception.CustomerAlreadyExistsException;
import com.easyToBank.exception.ResourceNotFoundException;
import com.easyToBank.mapper.AccountsMapper;
import com.easyToBank.mapper.CustomerMapper;
import com.easyToBank.repository.AccountsRepository;
import com.easyToBank.repository.CustomerRepository;
import com.easyToBank.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountService implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber "
                    + customerDTO.getMobileNumber());
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    @Override
    public CustomerDTO fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "Mobile Number", mobileNumber));
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));
        CustomerDTO customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDTO());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDTO()));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDTO customerDTO) {
        return false;
    }
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        return newAccount;
    }
}
