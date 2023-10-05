package com.vinizorza.urnaeletronica.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Candidate {

    @Id
    private String number;

    private String name;

    private String viceName;

    private String imageUrl;

    private String viceImageUrl;

    private String party;

    private String city;

    private String state;

    @Enumerated(EnumType.STRING)
    private Position position;

}