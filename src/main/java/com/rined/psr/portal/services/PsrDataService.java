package com.rined.psr.portal.services;

import com.rined.psr.portal.model.PsrData;
import com.rined.psr.portal.model.User;
import com.rined.psr.portal.model.converters.PsrDataConverter;
import com.rined.psr.portal.model.dto.brief.PsrDataBrief;
import com.rined.psr.portal.model.dto.fully.PsrDataDto;
import com.rined.psr.portal.repositories.PsrDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PsrDataService extends BaseService<PsrDataDto, PsrDataBrief, PsrData, Long, PsrDataRepository,
        PsrDataConverter> {
    private final PsrService psrService;
    private final UserService userService;

    @Autowired
    public PsrDataService(PsrDataConverter converter,
                          PsrDataRepository repository,
                          PsrService psrService,
                          UserService userService) {
        super(converter, repository);
        this.psrService = psrService;
        this.userService = userService;
    }

    @Override
    public PsrData cascadeSave(PsrData psrData) {
        if (Objects.nonNull(psrData) && Objects.isNull(psrData.getId())) {
            psrService.cascadeSave(psrData.getPsr());
            userService.cascadeSave(psrData.getPsrLeader());
            userService.cascadeSave(psrData.getPsrRegisteredUser());
            repository.save(psrData);
        }
        return psrData;
    }

    public void create(User user, PsrDataBrief psrDataBrief) {
        PsrData psrData = converter.briefToBase(psrDataBrief);
        if (Objects.isNull(psrData.getPsrLeader()))
            psrData.setPsrLeader(user);
        if (Objects.isNull(psrData.getPsrRegisteredUser()))
            psrData.setPsrRegisteredUser(user);
        cascadeSave(psrData);
    }
}
