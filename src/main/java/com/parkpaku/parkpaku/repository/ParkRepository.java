package com.parkpaku.parkpaku.repository;

import com.parkpaku.parkpaku.entity.ParkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkRepository extends JpaRepository<ParkEntity, Long> {
}
