package com.example.fooddelivery.service;

import com.Food_Delivery.entity.FoodEntity;
import com.Food_Delivery.repository.FoodRep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServices {

    private final FoodRep repository;

    public FoodService(FoodItemRepository repository) {
        this.repository = repository;
    }

    public List<FoodItem> getAllItems() {
        return repository.findAll();
    }

    public Optional<FoodItem> getItemById(Long id) {
        return repository.findById(id);
    }

    public FoodItem saveItem(FoodItem item) {
        return repository.save(item);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }
}