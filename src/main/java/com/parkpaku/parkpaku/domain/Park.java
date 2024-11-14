package com.parkpaku.parkpaku.domain;

import lombok.Builder;

@Builder
public class Park {
    private Long id;
    private String name;
    private String type;
    private String description;
    private String location;
    private Long like;
}
