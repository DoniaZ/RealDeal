package com.zmander.Bet.Controller;


import com.zmander.Bet.entities.Bet;
import com.zmander.Bet.repository.BetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bets")
@RequiredArgsConstructor
public class BetController {

    @Autowired
    private final BetRepository betRepository;

    @GetMapping
    public List<Bet> getAllBets() {
        return betRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bet> getBetById(@PathVariable UUID id) {
        return betRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bet createBet(@RequestBody Bet bet) {
        return betRepository.save(bet);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBet(@PathVariable UUID id) {
        return betRepository.findById(id)
                .map(bet -> {
                    betRepository.delete(bet);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    
}