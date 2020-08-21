package com.ferret56.app.bpm;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckPaymentValue implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int payment = (int) delegateExecution.getVariable("payment");
        if (payment < 200){
            delegateExecution.setVariable("paymentOk", false);
        }
        else {
            delegateExecution.setVariable("paymentOk", true);
        }
    }
}
