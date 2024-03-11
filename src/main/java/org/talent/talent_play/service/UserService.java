package org.talent.talent_play.service;

import org.talent.talent_play.domain.UserInfo;
import org.talent.talent_play.domain.UserValidateRequest;

public interface UserService {
    UserInfo validateUser(UserValidateRequest request);
}
