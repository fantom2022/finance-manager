package com.artg.financemanager.entities;

import com.artg.financemanager.entities.enums.OperationDirectionEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_operation")
    @SequenceGenerator(allocationSize = 0, sequenceName = "sq_operation_id", name = "sq_operation")
    private Long id;
    @Enumerated(EnumType.STRING)
    private OperationDirectionEnum direction;
    private Double price;
}
