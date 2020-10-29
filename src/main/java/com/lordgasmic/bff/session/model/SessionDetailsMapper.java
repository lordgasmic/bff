package com.lordgasmic.bff.session.model;

import com.lordgasmic.bff.login.model.UserInfo;
import com.lordgasmic.bff.session.SessionManager;

public class SessionDetailsMapper {
    public static SessionDetails fromUserInfo(UserInfo userInfo) {
        return SessionDetails.builder()
                             .id(userInfo.getId())
                             .roles(userInfo.getRoles())
                             .username(userInfo.getUsername())
                             .build();
    }
}
