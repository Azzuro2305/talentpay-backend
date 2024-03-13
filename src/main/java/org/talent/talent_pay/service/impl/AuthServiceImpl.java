package org.talent.talent_pay.service.impl;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.talent.talent_pay.cache.OTP;
import org.talent.talent_pay.cache.OTPCache;
import org.talent.talent_pay.constant.EmailConstant;
import org.talent.talent_pay.domain.OTPValidateRequest;
import org.talent.talent_pay.entity.Users;
import org.talent.talent_pay.repo.UserRepo;
import org.talent.talent_pay.service.AuthService;
import org.talent.talent_pay.util.EmailUtil;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;
    private EmailUtil emailUtil;
    @Override
    public void verifyMailToRegister(String mail) {
        final Optional<Users> user = userRepo.findUsersByMail(mail);
        if(user.isPresent()) {
            throw  new RuntimeException("User already exist.");
        } else {
            Random random = new Random();
            final int min = 100000;
            final int max = 1000000;
            final int r = random.nextInt(min, max);
            System.out.println("Generating Secret Key");
            System.out.println(r);
            send(mail, String.valueOf(r));

            OTP otp = new OTP(mail, Integer.toString(r), LocalDateTime.now().plusMinutes(1));
            OTPCache.saveOTP(otp);
        }

    }

    @Override
    public boolean validateOTP(OTPValidateRequest request) {
        boolean isValidate = false;
        final OTP otp = OTPCache.getOTP(request.getMail());
        // validate otp correct
        if (otp != null) {
            if(otp.getOtp().equals(request.getOtp())) {
                if(LocalDateTime.now().isBefore(otp.getExpiredTIme())) {
                    // validate expired time
                    isValidate = true;
                }
            }
        }
        return isValidate;
    }

    private void send(String toEmail, String subject){
        final String fromEmail = EmailConstant.senderMail; //requires valid email
        final String password = EmailConstant.senderPassword;

        Properties props = new Properties();
        props.put("mail.smtp.host", EmailConstant.SMTP_HOST); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.port", "465"); //SMTP Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        props.put("mail.debug", "true");

        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getInstance(props, auth);
        emailUtil.sendEmail(session, toEmail, subject);
    }
}
