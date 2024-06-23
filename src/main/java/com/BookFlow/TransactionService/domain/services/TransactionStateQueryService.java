package com.BookFlow.TransactionService.domain.services;

import com.BookFlow.TransactionService.domain.model.aggregates.PaymentMethod;
import com.BookFlow.TransactionService.domain.model.aggregates.TransactionState;
import com.BookFlow.TransactionService.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface TransactionStateQueryService {
    Optional<TransactionState> handle(GetTransactionStateByIdQuery query);
    Optional<TransactionState> handle(GetTransactionStateByNameQuery query);
    List<TransactionState> handle(GetAllTransactionStatesQuery query);
}
