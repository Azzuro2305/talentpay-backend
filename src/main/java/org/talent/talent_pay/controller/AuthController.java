package org.talent.talent_pay.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talent.talent_pay.domain.OTPValidateRequest;
import org.talent.talent_pay.domain.TalentResponse;
import org.talent.talent_pay.service.AuthService;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@CrossOrigin
public class AuthController {
    @Autowired
    private final AuthService authService;
    @GetMapping("/verify")
    public void verifyEmail(@RequestParam String mail) {
        System.out.println("Verifying mail " + mail);
        authService.verifyMailToRegister(mail);
    }

    @PostMapping("validateOTP")
    public ResponseEntity<TalentResponse<Boolean>> validateOTP(@RequestBody OTPValidateRequest request) {
        boolean isValidate = authService.validateOTP(request);
        TalentResponse<Boolean> response =
                new TalentResponse<>(isValidate, "OTP is validated", HttpStatus.OK);
        return ResponseEntity.ok(response);
    }
}
