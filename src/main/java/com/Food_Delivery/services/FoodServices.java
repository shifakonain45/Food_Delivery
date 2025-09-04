package com.Food_Delivery.services;

import com.Food_Delivery.entity.FoodEntity;
import com.Food_Delivery.repository.FoodRep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServices {

    private final FoodRep repository;

    // Constructor Injection
    public FoodServices(FoodRep repository) {
        this.repository = repository;
    }

    // Get all food items
    public List<FoodEntity> getAllItems() {
        return repository.findAll();
    }

    // Get food item by id
    public Optional<FoodEntity> getItemById(Long id) {
        return repository.findById(id);
    }

    // Save new food item
    public FoodEntity saveItem(FoodEntity item) {
        return repository.save(item);
    }

    // Delete food item
    public void deleteItem(Long id) {
        repository.deleteById(id);
    }
}
