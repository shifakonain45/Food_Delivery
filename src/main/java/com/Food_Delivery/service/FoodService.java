package com.Food_Delivery.service;

import com.Food_Delivery.entity.FoodEntity;
import com.Food_Delivery.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<FoodEntity> getAllFoods() {
        return foodRepository.findAll();
    }

    public Optional<FoodEntity> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    public FoodEntity saveFood(FoodEntity food) {
        return foodRepository.save(food);
    }

    public FoodEntity updateFood(Long id, FoodEntity updatedFood) {
        return foodRepository.findById(id).map(food -> {
            food.setName(updatedFood.getName());
            food.setPrice(updatedFood.getPrice());
            food.setDescription(updatedFood.getDescription());
            food.setAvailable(updatedFood.getAvailable());
            return foodRepository.save(food);
        }).orElseThrow(() -> new RuntimeException("Food not found with id " + id));
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}
