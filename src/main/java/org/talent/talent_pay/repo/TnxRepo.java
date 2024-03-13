package org.talent.talent_pay.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.talent.talent_pay.entity.Transaction;

import java.util.UUID;

public interface TnxRepo extends JpaRepository<Transaction, UUID> {

}
