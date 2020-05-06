package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.PsrListRegistration;
import com.rined.psr.portal.model.VolunteerStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PsrListRegistrationRepository extends BaseRepository<PsrListRegistration, Long> {

    @Query("from PsrListRegistration psrList where psrList.psr.id=:id")
    List<PsrListRegistration> findPsrListRegistrationsByPsr(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update PsrListRegistration psrList set psrList.volunteerStatus = :status " +
            "where psrList.volunteer.id in (:ids)")
    void changeVolunteerStatusForPsrListRegistrations(@Param("ids") List<Long> ids,
                                                      @Param("status") VolunteerStatus volunteerStatus);
}
