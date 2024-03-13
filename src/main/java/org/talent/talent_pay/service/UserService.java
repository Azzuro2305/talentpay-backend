package org.talent.talent_pay.service;

import org.talent.talent_pay.domain.UserInfo;
import org.talent.talent_pay.domain.UserValidateRequest;

public interface UserService {
    UserInfo validateUser(UserValidateRequest request);
}
