package com.rined.psr.portal.services;

import com.rined.psr.portal.repositories.ClassificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;


}
