package com.example.demo.info;

import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.SimpleTransactionStatus;


@Component

public class InfoOnSpringTransaction implements  PlatformTransactionManager {
	
	
	@Override
    public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
        System.out.println("▶️ Starting non-database transaction...");
        // You can capture current state snapshots here for later rollbacks
        return new SimpleTransactionStatus();
    }

    @Override
    public void commit(TransactionStatus status) throws TransactionException {
        System.out.println("✅ Committing changes permanently to state/API...");
    }

    @Override
    public void rollback(TransactionStatus status) throws TransactionException {
        System.out.println("❌ Rollback triggered! Reverting in-memory changes or calling compensating APIs...");
    }

}
