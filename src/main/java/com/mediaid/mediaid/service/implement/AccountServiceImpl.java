package com.mediaid.mediaid.service.implement;

import com.mediaid.mediaid.repository.AccountRepo;
import com.mediaid.mediaid.service.abstracts.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepo accountRepo;
    @Override
    public ResponseEntity<?> getAccountInformationOfBenhNhan(String accountID) {

        return null;
    }
}
