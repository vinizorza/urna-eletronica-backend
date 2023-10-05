package com.vinizorza.urnaeletronica.controller.dto;

import lombok.Builder;

@Builder
public record VoteDTO(
        String candidateNumber,
        String city,
        String state) {
}
