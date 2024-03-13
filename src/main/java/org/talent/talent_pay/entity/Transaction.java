package org.talent.talent_pay.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private long amount;
    private String note;
    private LocalDateTime tnxDate;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserAccount sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private UserAccount receiver;
}
