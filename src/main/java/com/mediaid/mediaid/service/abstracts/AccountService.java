package com.mediaid.mediaid.service.abstracts;

import org.springframework.http.ResponseEntity;

public interface AccountService {
    ResponseEntity<?> getAccountInformationOfBenhNhan(String accountID);

}
