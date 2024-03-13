package org.talent.talent_pay.domain;

import lombok.Getter;
import lombok.Setter;
import org.talent.talent_pay.entity.Users;

@Getter
@Setter
public class UserInfo {
    private String userName;
    private String secretPhoneNumber;

    public static UserInfo of(Users user) {
        UserInfo userInfo = new UserInfo();
        userInfo.userName = user.getUserName();
        userInfo.secretPhoneNumber = "********" +
                user.getPhoneNumber().substring(0, user.getPhoneNumber().length() - 4);
        return userInfo;
    }
}
