package com.artg.financemanager.dtos;

import com.artg.financemanager.entities.enums.OperationDirectionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDto {
    private Long id;
    private OperationDirectionEnum direction;
    private Double price;
}
