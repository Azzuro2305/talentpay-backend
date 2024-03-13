package org.talent.talent_pay.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.talent.talent_pay.domain.UserInfo;
import org.talent.talent_pay.domain.UserValidateRequest;
import org.talent.talent_pay.entity.Users;
import org.talent.talent_pay.repo.UserRepo;
import org.talent.talent_pay.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public UserInfo validateUser(UserValidateRequest request) {
        // validate user with phoneNumber
        // if does not exist, error response
        // or else return user details
        final Users user = userRepo
                .findUsersByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserInfo.of(user);
    }
}