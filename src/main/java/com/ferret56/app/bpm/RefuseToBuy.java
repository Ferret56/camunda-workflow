package com.ferret56.app.bpm;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RefuseToBuy implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
       log.info("Oh, sorry:(");
    }
}
