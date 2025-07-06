package com.example.expensetracker.model;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class expense {

    @Id
    private String id;

    @Positive(message = "Amount must be greater than 0")
    private BigDecimal amount;

    private LocalDate date;

    private String purpose;

    private String discription;
}
