package com.vinizorza.urnaeletronica.controller.dto;

import com.vinizorza.urnaeletronica.entity.Position;
import lombok.Builder;

@Builder
public record CandidateDTO(
        String number,
        String name,
        String viceName,
        String imageUrl,
        String viceImageUrl,
        String party,
        String city,
        String state,
        Position position) {
}
