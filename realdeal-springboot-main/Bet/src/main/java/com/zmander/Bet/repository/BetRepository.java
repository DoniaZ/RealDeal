package com.zmander.Bet.repository;

import com.zmander.Bet.entities.Bet;
import com.zmander.Bet.entities.BetStatus;
import com.zmander.Bet.entities.BetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BetRepository extends JpaRepository<Bet, UUID> {

    List<Bet> findByBetType(BetType betType);

    List<Bet> findByStatus(BetStatus status);
}
