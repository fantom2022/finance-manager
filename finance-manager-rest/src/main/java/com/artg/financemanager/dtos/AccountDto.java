package com.artg.financemanager.dtos;

import com.artg.financemanager.entities.enums.AccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDto {
    private Long id;
    private AccountTypeEnum accountType;
    private List<OperationDto> operations;
}
