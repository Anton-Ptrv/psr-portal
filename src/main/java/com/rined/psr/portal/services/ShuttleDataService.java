package com.rined.psr.portal.services;

import com.rined.psr.portal.dto.brief.ShuttleDataBrief;
import com.rined.psr.portal.dto.fully.ShuttleDataDto;

import java.util.List;

public interface ShuttleDataService {

    void addShuttleData(ShuttleDataBrief brief);

    List<ShuttleDataDto> getAllShuttlesData();

    void updateShuttleData(long id, ShuttleDataDto dto);

    ShuttleDataDto getShuttleById(long id);

    void deleteShuttleDataById(long id);

}
