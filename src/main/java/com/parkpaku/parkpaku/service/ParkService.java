package com.parkpaku.parkpaku.service;

import com.parkpaku.parkpaku.dto.ReviewDto;
import com.parkpaku.parkpaku.entity.MemberEntity;
import com.parkpaku.parkpaku.entity.ParkEntity;
import com.parkpaku.parkpaku.entity.ReviewEntity;
import com.parkpaku.parkpaku.repository.MemberRepository;
import com.parkpaku.parkpaku.repository.ParkRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkService {
    final ParkRepository parkRepository;
    final MemberRepository memberRepository;

    @Autowired
    ParkService(ParkRepository parkRepository, MemberRepository memberRepository) {
        this.parkRepository = parkRepository;
        this.memberRepository = memberRepository;
    }
    public ParkEntity findParkById(Long id) {
        Optional<ParkEntity> optionalParkEntity = parkRepository.findById(id);

        if(optionalParkEntity.isEmpty()) {
            throw new RuntimeException("존재하지 않는 공원을 찾지 마세요!!!");
        }

        return optionalParkEntity.get();
    }

    public void reviewPark(ReviewDto reviewDto) {
        Optional<ParkEntity> park = parkRepository.findById(reviewDto.getPark_id());
        Optional<MemberEntity> author = memberRepository.findById(reviewDto.getAuthor_id());

        if(park.isEmpty()) {
            throw new EntityNotFoundException("존재하지 않는 공원입니다!!");
        }
        if(author.isEmpty()) {
            throw new EntityNotFoundException("존재하지 않는 회원입니다!!");
        }

        ReviewEntity review = ReviewEntity.builder()
                .park(park.get())
                .member(author.get())
                .writeDate(reviewDto.getWrite_date())
                .content(reviewDto.getContent())
                .build();

        park.get().getReviews().add(review);
    }

    public void likePark(Long id) {
        Optional<ParkEntity> park = parkRepository.findById(id);

        if(park.isEmpty()) {
            throw new EntityNotFoundException("존재하지 않는 회원입니다!!");
        }

        ParkEntity parkEntity = park.get();
        parkEntity.setLikes(parkEntity.getLikes() + 1);
    }
}
