package com.parkpaku.parkpaku.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkDto {
    private Long id;
    private String name;
    private String type;
    private String description;
    private String location;
    private double latitude;
    private double longitude;
    private Long likes;
}
