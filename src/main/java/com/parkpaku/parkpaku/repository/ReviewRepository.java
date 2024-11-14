package com.parkpaku.parkpaku.repository;

import com.parkpaku.parkpaku.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
