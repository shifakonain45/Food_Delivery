package com.example.fooddelivery.service;

import com.example.fooddelivery.entity.FoodItem;
import com.example.fooddelivery.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private final FoodItemRepository repository;

    public FoodItemService(FoodItemRepository repository) {
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