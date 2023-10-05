package com.vinizorza.urnaeletronica.controller.mapper;

import com.vinizorza.urnaeletronica.controller.dto.CandidateDTO;
import com.vinizorza.urnaeletronica.controller.dto.CandidateResultDTO;
import com.vinizorza.urnaeletronica.entity.Candidate;
import org.springframework.stereotype.Component;

@Component
public class CandidateMapper {

    public static CandidateDTO toDto(Candidate entity){
        return CandidateDTO.builder()
                .number(entity.getNumber())
                .party(entity.getParty())
                .state(entity.getState())
                .city(entity.getCity())
                .name(entity.getName())
                .imageUrl(entity.getImageUrl())
                .position(entity.getPosition())
                .viceImageUrl(entity.getViceImageUrl())
                .viceName(entity.getViceName())
                .build();
    }

    public static CandidateResultDTO toDto(Candidate entity, Long voteQuantity){
        return CandidateResultDTO.builder()
                .number(entity.getNumber())
                .party(entity.getParty())
                .state(entity.getState())
                .city(entity.getCity())
                .name(entity.getName())
                .imageUrl(entity.getImageUrl())
                .position(entity.getPosition())
                .viceImageUrl(entity.getViceImageUrl())
                .viceName(entity.getViceName())
                .voteQuantity(voteQuantity)
                .build();
    }

}
