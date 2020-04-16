package com.rined.psr.portal.services;

import com.rined.psr.portal.model.PsrListRegistration;
import com.rined.psr.portal.model.converters.PsrListRegistrationConverter;
import com.rined.psr.portal.model.converters.VolunteerStatusConverter;
import com.rined.psr.portal.model.dto.brief.PsrListRegistrationBrief;
import com.rined.psr.portal.model.dto.fully.PsrListRegistrationDto;
import com.rined.psr.portal.model.dto.request.PsrListRegistrationVolunteersStatus;
import com.rined.psr.portal.repositories.PsrListRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PsrListRegistrationService extends BaseService<PsrListRegistrationDto, PsrListRegistrationBrief,
        PsrListRegistration, Long, PsrListRegistrationRepository, PsrListRegistrationConverter> {

    private final PsrService psrService;
    private final VolunteerService volunteerService;
    private final VolunteerStatusService volunteerStatusService;
    private final VolunteerStatusConverter volunteerStatusConverter;

    @Autowired
    public PsrListRegistrationService(PsrListRegistrationConverter converter,
                                      PsrListRegistrationRepository repository,
                                      PsrService psrService,
                                      VolunteerService volunteerService,
                                      VolunteerStatusService volunteerStatusService,
                                      VolunteerStatusConverter volunteerStatusConverter) {
        super(converter, repository);
        this.psrService = psrService;
        this.volunteerService = volunteerService;
        this.volunteerStatusService = volunteerStatusService;
        this.volunteerStatusConverter = volunteerStatusConverter;
    }

    @Override
    public PsrListRegistration cascadeSave(PsrListRegistration psrListRegistration) {
        if (Objects.nonNull(psrListRegistration) && Objects.isNull(psrListRegistration.getId())) {
            psrService.cascadeSave(psrListRegistration.getPsr());
            volunteerService.cascadeSave(psrListRegistration.getVolunteer());
            volunteerStatusService.cascadeSave(psrListRegistration.getVolunteerStatus());

            return repository.save(psrListRegistration);
        }
        return psrListRegistration;
    }

    public List<PsrListRegistrationDto> getPsrListRegistrationsByPsr(Long id) {
        List<PsrListRegistration> psrListRegistrationsByPsr = repository.findPsrListRegistrationsByPsr(id);
        return converter.baseToDtoList(psrListRegistrationsByPsr);
    }

    public void changeVolunteerStatusForPsrListRegistrations(PsrListRegistrationVolunteersStatus newStatus) {
        repository.changeVolunteerStatusForPsrListRegistrations(
                newStatus.getIds(),
                volunteerStatusConverter.dtoToBase(newStatus.getVolunteerStatus())
        );
    }
}
