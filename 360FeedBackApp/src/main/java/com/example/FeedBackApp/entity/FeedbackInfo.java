package com.example.FeedBackApp.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "FeedbackInfo")
public class FeedbackInfo {

    private Integer empId;
    private List<String> feedbackReport;

    public FeedbackInfo(Integer empId) {
        this.empId = empId;
    }

    @DynamoDBHashKey
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @DynamoDBAttribute
    public List<String> getFeedbackReport() {
        return feedbackReport;
    }

    public void setFeedbackReport(List<String> feedbackReport) {
        this.feedbackReport = feedbackReport;
    }

    @Override
    public String toString() {
        return "FeedbackInfo{" +
                "empId=" + empId +
                ", feedbackReport=" + feedbackReport +
                '}';
    }
}
