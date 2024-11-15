package com.parkpaku.parkpaku.domain;

import lombok.Builder;

@Builder
public class Member {
    String name;
    String memberId;
    String password;
    String location;
}
