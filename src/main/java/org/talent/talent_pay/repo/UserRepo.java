package org.talent.talent_pay.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.talent.talent_pay.entity.Users;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<Users, UUID> {
    Optional<Users> findUsersByPhoneNumber(String phoneNumber);
    Optional<Users> findUsersByMail(String mail);
}
