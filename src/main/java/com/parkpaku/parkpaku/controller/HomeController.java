package com.parkpaku.parkpaku.controller;

import com.parkpaku.parkpaku.dto.MemberDto;
import com.parkpaku.parkpaku.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final MemberService memberService;

    @Autowired
    HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Long> addMember(@RequestBody MemberDto member) {
        Long id = memberService.join(member);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}
