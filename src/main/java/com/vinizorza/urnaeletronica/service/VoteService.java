package com.vinizorza.urnaeletronica.service;

import com.vinizorza.urnaeletronica.entity.Candidate;
import com.vinizorza.urnaeletronica.entity.Vote;
import com.vinizorza.urnaeletronica.repository.VoteRepository;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class VoteService {

    private VoteRepository repository;

    public VoteService(final VoteRepository repository) {
        this.repository = repository;
    }

    public Long countVotes(final String number){
        return repository.countByCandidateNumber(number);
    }

    public void createVote(final Vote vote, final String state, final String city) throws Exception {

        validateLocation(vote.getCandidate(), city, state);

        repository.save(vote);
    }

    private void validateLocation(final Candidate candidate, final String city, final String state) throws Exception {

        if(nonNull(candidate.getState()) && !candidate.getState().equals(state))
            throw new Exception("Candidato não pertence ao estado do eleitor");

        if(nonNull(candidate.getCity()) && !candidate.getCity().equals(city))
            throw new Exception("Candidato não pertence a cidade do eleitor");

    }
}
