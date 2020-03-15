package com.rined.psr.portal.dto.fully;

import com.rined.psr.portal.model.Psr;
import com.rined.psr.portal.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PsrDataDto {

    private long id;

    private PsrDto psr;

    private String station;

    private UserDto psrLeader;

    private UserDto psrRegisteredUser;

    private String objectInfo;

    private String content;

    private byte[] photo;
}
