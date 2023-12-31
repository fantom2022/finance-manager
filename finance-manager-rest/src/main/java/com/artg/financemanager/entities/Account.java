package com.artg.financemanager.entities;

import com.artg.financemanager.dtos.AccountDto;
import com.artg.financemanager.entities.enums.AccountTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    @Id
    @GeneratedValue(generator = "sq_account", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "sq_account_id", name = "sq_account", allocationSize = 0)
    private Long id;
    @Enumerated(EnumType.STRING)
    private AccountTypeEnum accountType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_id")
    private Set<Operation> operations = new HashSet<>();


    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }

    public void removeOperation(Operation operation) {
        this.operations.remove(operation);
    }

    public Account(AccountDto dto) {
        update(dto);
    }

    public void update(AccountDto dto) {
        this.accountType = dto.getAccountType();
    }

    public void delete() {

    }
}
