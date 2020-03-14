package com.rined.psr.portal.services;

import com.rined.psr.portal.repositories.ShuttleDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShuttleDataServiceImpl implements ShuttleDataService {
    private final ShuttleDataRepository shuttleDataRepository;
}
