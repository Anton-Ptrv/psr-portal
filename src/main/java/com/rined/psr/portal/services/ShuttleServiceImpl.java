package com.rined.psr.portal.services;

import com.rined.psr.portal.repositories.ShuttleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShuttleServiceImpl implements ShuttleService {
    private final ShuttleRepository shuttleRepository;
}
