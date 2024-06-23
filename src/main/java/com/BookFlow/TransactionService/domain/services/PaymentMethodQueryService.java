package com.BookFlow.TransactionService.domain.services;

import com.BookFlow.TransactionService.domain.model.aggregates.PaymentMethod;
import com.BookFlow.TransactionService.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodQueryService {
    Optional<PaymentMethod> handle(GetPaymentMethodByIdQuery query);
    Optional<PaymentMethod> handle(GetPaymentMethodByNameQuery query);
    List<PaymentMethod> handle(GetAllPaymentMethodsQuery query);
}
