package com.zmander.Bet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID betId;

    @Enumerated(EnumType.STRING)
    private BetType betType;

    @Enumerated(EnumType.STRING)
    private BetStatus status;

    private float amount;
    private float rating;
    private float gain;
    private LocalDateTime createdAt;


}