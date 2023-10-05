package com.vinizorza.urnaeletronica.controller;

import com.vinizorza.urnaeletronica.controller.dto.VoteDTO;
import com.vinizorza.urnaeletronica.entity.Vote;
import com.vinizorza.urnaeletronica.service.CandidateService;
import com.vinizorza.urnaeletronica.service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/vote")
public class VoteController {

    private VoteService voteService;
    private CandidateService candidateService;

    public VoteController(final VoteService voteService,
                          final CandidateService candidateService) {
        this.voteService = voteService;
        this.candidateService = candidateService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createVote(@RequestBody VoteDTO dto) throws Exception {
        final Vote vote = Vote.builder()
                .candidate(candidateService.findByNumber(dto.candidateNumber()))
                .time(LocalDateTime.now())
                .build();
        voteService.createVote(vote, dto.state(), dto.city());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
