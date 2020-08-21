package com.ferret56.app.bpm;

import com.ferret56.app.service.PaymentValidationService;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CheckPaymentValue implements JavaDelegate {

    private final PaymentValidationService paymentValidationService;

    public CheckPaymentValue(PaymentValidationService paymentValidationService) {
        this.paymentValidationService = paymentValidationService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int payment = (int) delegateExecution.getVariable("payment");
        if (!paymentValidationService.validatePaymentForPositiveValue(payment)){
            throw new BpmnError("paymentError");
        }
        if (!paymentValidationService.validatePaymentForEnoughValue(payment)){
            delegateExecution.setVariable("paymentOk", false);
        }
        else {
            delegateExecution.setVariable("paymentOk", true);
        }
    }
}
