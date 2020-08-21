package com.ferret56.app.service;

public interface PaymentValidationService {
    boolean validatePaymentForPositiveValue(int payment);
    boolean validatePaymentForEnoughValue(int payment);
}
