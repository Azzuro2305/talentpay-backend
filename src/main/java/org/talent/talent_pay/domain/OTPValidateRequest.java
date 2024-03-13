package org.talent.talent_pay.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OTPValidateRequest {
    private String mail;
    private String otp;
}

// request are created in domain when we interact with the frontend
// request are created in dto when we interact within the backend