package org.talent.talent_pay.service;

import org.talent.talent_pay.domain.OTPValidateRequest;

public interface AuthService {
    void verifyMailToRegister(String mail);

    boolean validateOTP(OTPValidateRequest request);
}
