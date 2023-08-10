package com.artg.financemanager.readers;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountReader {
    @Autowired
    protected JPAQueryFactory queryFactory;
}
