package org.talent.talent_play.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.talent.talent_play.entity.Transaction;

import java.util.UUID;

public interface TnxRepo extends JpaRepository<Transaction, UUID> {

}
