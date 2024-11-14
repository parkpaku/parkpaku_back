package com.parkpaku.parkpaku.service;

import com.parkpaku.parkpaku.Exception.InvalidCredentialsException;
import com.parkpaku.parkpaku.entity.MemberEntity;
import com.parkpaku.parkpaku.dto.MemberDto;
import com.parkpaku.parkpaku.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    final MemberRepository memberRepository;

    @Autowired
    MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // CRUD
    public Long join(MemberDto member) {
        MemberEntity memberEntity = MemberEntity.builder()
                .name(member.getName())
                .memberId(member.getMemberId())
                .password(member.getPassword())
                .location(member.getLocation())
                .build();
        return memberRepository.save(memberEntity).getId();
    }

    public void login(String memberId, String memberPassword) {
        Optional<MemberEntity> member = memberRepository.findByMemberId(memberId);
        if(member.isEmpty() || !member.get().getPassword().equals(memberPassword)) {
            throw new InvalidCredentialsException("잘못된 로그인 시도입니다!!");
        }
    }
}
