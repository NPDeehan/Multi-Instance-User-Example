package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
public class VoteCountListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        Long yesVotes = (Long) delegateTask.getVariable("yesVotes");
        Long noVotes = (Long) delegateTask.getVariable("noVotes");
        boolean approved = (boolean)delegateTask.getVariable("approved");

        if(approved){
            delegateTask.setVariable("yesVotes", yesVotes+1L);
        }else{
            delegateTask.setVariable("noVotes", noVotes+1L);
        }

//        Map<String, Object> vars = new HashMap<String, Object>();
//        vars.put("approved", )
        // Now i'll removed the variables so that no other task are affected by it.
        delegateTask.removeVariable("approved");
        delegateTask.removeVariable("name");


    }
}
