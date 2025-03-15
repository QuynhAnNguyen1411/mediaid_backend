package com.mediaid.mediaid.service.abstracts;

import org.springframework.http.ResponseEntity;

public interface StaticService {
    ResponseEntity<?> getStaticRegistryData();
    ResponseEntity<?> getStaticDataForTieuSuYTe();
}
