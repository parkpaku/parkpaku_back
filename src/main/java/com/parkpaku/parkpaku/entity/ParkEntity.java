package com.parkpaku.parkpaku.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="park")
public class ParkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="type", nullable = false)
    private String type;
    @Column(name="description")
    private String description;
    @Column(name="location", nullable = false)
    private String location;
    @Column(name="likes")
    private Long likes;
    @Column(name="latitude")
    private double latitude;
    @Column(name="longitude")
    private double longitude;
    @Builder.Default
    @OneToMany(mappedBy = "park")  // 'park' 필드에서 이 관계가 매핑됨
    private List<ReviewEntity> reviews = new ArrayList<>();
    @Builder.Default
    @OneToMany(mappedBy = "park")
    private Set<MemberParkVisitEntity> memberVisits = new HashSet<MemberParkVisitEntity>();
}
