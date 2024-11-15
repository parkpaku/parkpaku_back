package com.parkpaku.parkpaku.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ReviewDto {
    Long park_id;
    Long author_id;
    Date write_date;
    String content;
}
