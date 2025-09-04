package com.Food_Delivery.controller;

import com.Food_Delivery.entity.FoodEntity;
import com.Food_Delivery.services.FoodServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    private final FoodServices foodServices;

    public FoodController(FoodServices foodServices) {
        this.foodServices = foodServices;
    }

    // ✅ Create new food item
    @PostMapping
    public FoodEntity createFood(@RequestBody FoodEntity food) {
        return foodServices.saveItem(food);
    }

    // ✅ Get all food items
    @GetMapping
    public List<FoodEntity> getAllFood() {
        return foodServices.getAllItems();
    }

    // ✅ Get one food item by ID
    @GetMapping("/{id}")
    public FoodEntity getFoodById(@PathVariable Long id) {
        return foodServices.getItemById(id)
                .orElseThrow(() -> new RuntimeException("Food item not found with id " + id));
    }

    // ✅ Update food item
    @PutMapping("/{id}")
    public FoodEntity updateFood(@PathVariable Long id, @RequestBody FoodEntity foodDetails) {
        FoodEntity food = foodServices.getItemById(id)
                .orElseThrow(() -> new RuntimeException("Food item not found with id " + id));

        food.setName(foodDetails.getName());
        food.setPrice(foodDetails.getPrice());
        food.setDescription(foodDetails.getDescription());
        food.setAvailable(foodDetails.getAvailable());

        return foodServices.saveItem(food);
    }

    // ✅ Delete food item
    @DeleteMapping("/{id}")
    public String deleteFood(@PathVariable Long id) {
        foodServices.deleteItem(id);
        return "Food item deleted with id: " + id;
    }
}
