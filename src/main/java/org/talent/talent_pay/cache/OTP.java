package org.talent.talent_pay.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SoftDelete;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class OTP {
    private String mail;
    private String otp;
    private LocalDateTime expiredTIme;
}