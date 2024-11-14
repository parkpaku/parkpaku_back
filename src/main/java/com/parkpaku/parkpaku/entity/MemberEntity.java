package com.parkpaku.parkpaku.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="memberId", unique = true, nullable = false)
    private String memberId;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="location")
    private String location;
    @Builder.Default
    @OneToMany(mappedBy = "member")
    private Set<MemberParkVisitEntity> parkVisits = new HashSet<MemberParkVisitEntity>();
}
