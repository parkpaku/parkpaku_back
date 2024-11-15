package com.parkpaku.parkpaku.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "member_park_visit")
public class MemberParkVisitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "park_id")
    private ParkEntity park;
}
