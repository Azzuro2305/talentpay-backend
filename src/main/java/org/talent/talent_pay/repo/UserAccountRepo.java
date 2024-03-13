package org.talent.talent_pay.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.talent.talent_pay.entity.UserAccount;

public interface UserAccountRepo extends JpaRepository<UserAccount, Long> {

}
