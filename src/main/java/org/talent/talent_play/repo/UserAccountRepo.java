package org.talent.talent_play.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.talent.talent_play.entity.UserAccount;

public interface UserAccountRepo extends JpaRepository<UserAccount, Long> {

}
