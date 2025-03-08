package com.mediaid.mediaid.service.abtract;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface StaticService {
    ResponseEntity<?> getStaticRegistryData();
}
