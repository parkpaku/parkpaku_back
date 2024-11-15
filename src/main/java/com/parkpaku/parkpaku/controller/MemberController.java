package com.parkpaku.parkpaku.controller;

import com.parkpaku.parkpaku.dto.LoginDto;
import com.parkpaku.parkpaku.dto.MemberDto;
import com.parkpaku.parkpaku.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    final MemberService memberService;

    @Autowired
    MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @PostMapping("/signup")
    ResponseEntity<Long> signUp(MemberDto member) {
        try {
            return ResponseEntity.ok(memberService.join(member));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PostMapping("/login")
    void login(LoginDto loginDto) {
        memberService.login(loginDto.getMemberId(), loginDto.getPassword());
    }
}
