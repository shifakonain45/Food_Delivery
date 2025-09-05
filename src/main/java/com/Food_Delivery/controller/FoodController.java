package com.Food_Delivery.controller;

import com.Food_Delivery.entity.FoodEntity;
import com.Food_Delivery.service.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
@Tag(name = "Food API", description = "Operations related to food items")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    @Operation(summary = "Get all food items")
    public List<FoodEntity> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a food item by ID")
    public ResponseEntity<FoodEntity> getFoodById(@PathVariable Long id) {
        return foodService.getFoodById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public FoodEntity createFood(@RequestBody FoodEntity food) {
        food.setId(null); // ✅ force Hibernate to treat it as new
        return foodService.saveFood(food);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update a food item by ID")
    public ResponseEntity<FoodEntity> updateFood(@PathVariable Long id, @RequestBody FoodEntity updatedFood) {
        return ResponseEntity.ok(foodService.updateFood(id, updatedFood));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a food item by ID")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return ResponseEntity.noContent().build();
    }
}
