package com.example.FeedBackApp.model;

import org.springframework.stereotype.Component;

@Component
public class FeedBackModel {

    private Integer empId;
    private String feedback;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
