package com.parkpaku.parkpaku.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="park_id")
    private ParkEntity park;
    @ManyToOne
    @JoinColumn(name="author_id")
    private MemberEntity member;
    @Column(name="write_date")
    private Date writeDate;
    @Column(name="content")
    private String content;
}
