package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
public class ClearVotesListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {

        Map<String, Object> vars = new HashMap<String, Object>();

        vars.put("yesVotes", 0L);
        vars.put("noVotes", 0L);

        delegateExecution.setVariables(vars);

    }
}
