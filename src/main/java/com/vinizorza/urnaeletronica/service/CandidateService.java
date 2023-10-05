package com.vinizorza.urnaeletronica.service;

import com.vinizorza.urnaeletronica.controller.dto.CandidateResultDTO;
import com.vinizorza.urnaeletronica.controller.mapper.CandidateMapper;
import com.vinizorza.urnaeletronica.entity.Candidate;
import com.vinizorza.urnaeletronica.entity.Position;
import com.vinizorza.urnaeletronica.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService {

    private CandidateRepository repository;
    private VoteService voteService;
    private CandidateMapper candidateMapper;

    public CandidateService(final CandidateRepository repository,
                            final VoteService voteService,
                            final CandidateMapper candidateMapper) {
        this.repository = repository;
        this.voteService = voteService;
        this.candidateMapper = candidateMapper;
    }

    public List<CandidateResultDTO> listByPositionOrStateOrCity(final Position position,
                                                                final String state,
                                                                final String city) throws Exception {

        final List<Candidate> candidates = repository.findByPositionOrStateOrCity(position, state, city);

        final List<CandidateResultDTO> dtos = new ArrayList<>();

        candidates.forEach(candidate -> {
            dtos.add(candidateMapper.toDto(candidate, voteService.countVotes(candidate.getNumber())));
        });

        return dtos;
    }

    public Candidate findByNumber(final String number) throws Exception {
        return repository.findByNumber(number).orElseThrow(() -> new Exception("Candidato não encontrado"));
    }
}
