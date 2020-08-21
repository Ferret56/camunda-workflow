package com.ferret56.app.service.impl;

import com.ferret56.app.service.PaymentValidationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentValidationServiceImpl implements PaymentValidationService {

    @Value("${cost}")
    private int COST;

    @Override
    public boolean validatePaymentForPositiveValue(int payment) {
        return payment >= 0;
    }

    @Override
    public boolean validatePaymentForEnoughValue(int payment) {
        return payment >= COST;
    }
}
