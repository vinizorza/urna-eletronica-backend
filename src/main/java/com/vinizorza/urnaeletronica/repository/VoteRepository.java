package com.vinizorza.urnaeletronica.repository;

import com.vinizorza.urnaeletronica.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Long countByCandidateNumber(String number);

}
