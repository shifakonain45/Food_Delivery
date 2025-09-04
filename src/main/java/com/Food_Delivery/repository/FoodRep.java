package com.Food_Delivery.repository;

import com.Food_Delivery.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRep extends JpaRepository<FoodEntity, Long> {}
