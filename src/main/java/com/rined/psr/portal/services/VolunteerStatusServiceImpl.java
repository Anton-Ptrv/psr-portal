package com.rined.psr.portal.services;

import com.rined.psr.portal.repositories.VolunteerStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VolunteerStatusServiceImpl implements VolunteerStatusService {
    private final VolunteerStatusRepository volunteerStatusRepository;
}
