package com.example.expensetracker.controller;

import com.example.expensetracker.model.expense;
import com.example.expensetracker.repository.ExpenceRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.expensetracker.payload.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/expenses")
@Tag(name = "Expenses", description = "Expense Management APIs")
@RestController
public class expensecontroller {

    private final ExpenceRepository expenseRepository;

    @Autowired
    public expensecontroller(ExpenceRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

   /* @GetMapping("/expenses")
    public List<expense> find(){
        return expenseRepository.findAll();
    }*/
   @GetMapping("/expenses")
   public ResponseEntity<ApiResponse<List<expense>>> find() {
       List<expense> expenses = expenseRepository.findAll();
       ApiResponse<List<expense>> response = new ApiResponse<>(true, "Expenses fetched successfully", expenses);
       return new ResponseEntity<>(response, HttpStatus.OK);
   }


    /*@PostMapping("/expenses")
    public boolean saveExpenses(@Valid @RequestBody List<expense> expenses) {
        try {
            expenseRepository.saveAll(expenses);
            return true;
        } catch (Exception e) {
            return false;
        }
    }*/
    @PostMapping("/expenses")
    public ResponseEntity<ApiResponse> saveExpenses(@Valid @RequestBody List<expense> expenses) {
        try {
            expenseRepository.saveAll(expenses);
            ApiResponse response = new ApiResponse(true, "Expenses saved successfully!", null);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse(false, "Failed to save expenses", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   /* @DeleteMapping("/expenses/{id}")
    public boolean removexpenses(@PathVariable String id){
        Optional<expense> existing = expenseRepository.findById(id);
        if (existing.isPresent()) {
            expenseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }*/
   @DeleteMapping("/expenses/{id}")
   public ResponseEntity<ApiResponse<Boolean>> removeExpenses(@PathVariable String id) {
       Optional<expense> existing = expenseRepository.findById(id);
       if (existing.isPresent()) {
           expenseRepository.deleteById(id);
           ApiResponse<Boolean> response = new ApiResponse<>(true, "Expense deleted successfully", true);
           return new ResponseEntity<>(response, HttpStatus.OK);
       } else {
           ApiResponse<Boolean> response = new ApiResponse<>(false, "Expense not found", false);
           return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
       }
   }
   /*@PutMapping("/expense/{id}")
    public boolean updateexpenses(@PathVariable String id, @RequestBody expense expenses){
        try{
            Optional<expense> existing = expenseRepository.findById(id);
            expenseRepository.save(expenses);
            return true;
        } catch ( Exception e){
            return false;
        }
    }*/
    /*@PutMapping("/expenses/{id}")
    public boolean updateExpense(@PathVariable String id, @RequestBody expense updatedExpense) {
        try {
            Optional<expense> existing = expenseRepository.findById(id);
            if (existing.isPresent()) {
                expense Expense = existing.get();
                Expense.setAmount(updatedExpense.getAmount());
                Expense.setDate(updatedExpense.getDate());
                Expense.setPurpose(updatedExpense.getPurpose());
                Expense.setDiscription(updatedExpense.getDiscription());
                expenseRepository.save(Expense);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace(); // ← add this temporarily to debug if needed
            return false;
        }
    }*/

    @PutMapping("/expense/{id}")
    public ResponseEntity<ApiResponse<Boolean>> updateExpense(@PathVariable String id, @RequestBody expense updatedExpense) {
        Optional<expense> existing = expenseRepository.findById(id);
        if (existing.isPresent()) {
            expense Expense = existing.get();
            Expense.setAmount(updatedExpense.getAmount());
            Expense.setDate(updatedExpense.getDate());
            Expense.setPurpose(updatedExpense.getPurpose());
            Expense.setDiscription(updatedExpense.getDiscription());
            expenseRepository.save(Expense);
            ApiResponse<Boolean> response = new ApiResponse<>(true, "Expense updated successfully", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ApiResponse<Boolean> response = new ApiResponse<>(false, "Expense not found", false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }



}

