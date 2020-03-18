package com.rined.psr.portal.services;

import com.rined.psr.portal.dto.brief.ShuttleBrief;
import com.rined.psr.portal.dto.fully.ShuttleDto;

import java.util.List;

public interface ShuttleService {

    void addShuttle(ShuttleBrief brief);

    List<ShuttleDto> getAllShuttles();

    void updateShuttle(long id, ShuttleDto dto);

    ShuttleDto getShuttleById(long id);

    void deleteShuttleById(long id);

}
