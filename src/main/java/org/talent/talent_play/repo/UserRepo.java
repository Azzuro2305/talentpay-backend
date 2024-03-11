package org.talent.talent_play.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.talent.talent_play.entity.Users;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<Users, UUID> {
    Optional<Users> findUsersByPhoneNumber(String phoneNumber);
}
