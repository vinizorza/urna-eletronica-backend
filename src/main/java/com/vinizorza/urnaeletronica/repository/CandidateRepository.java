package com.vinizorza.urnaeletronica.repository;

import com.vinizorza.urnaeletronica.entity.Candidate;
import com.vinizorza.urnaeletronica.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {

    Optional<Candidate> findByNumber(String number);

    List<Candidate> findByPositionOrStateOrCity(Position position, String state, String city);

}
