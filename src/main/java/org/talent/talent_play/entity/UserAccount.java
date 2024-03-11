package org.talent.talent_play.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private long balance;
    private long point;
    private String qrCode;
    private boolean isDisabled;
    private boolean isDeleted;

    @OneToOne
    private Users owner;
}
