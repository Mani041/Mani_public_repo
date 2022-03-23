package com.example.FeedBackApp.test;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.example.FeedBackApp.Application;
import com.example.FeedBackApp.controller.FeedbackController;
import com.example.FeedBackApp.entity.FeedbackInfo;
import com.example.FeedBackApp.repository.FeedbackInfoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = {
        "amazon.dynamodb.endpoint=http://localhost:8000/",
        "amazon.aws.accesskey=test1",
        "amazon.aws.secretkey=test231" })
public class FeedbackInfoRepositoryIntegrationTest {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    FeedbackController feedbackController;

    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        CreateTableRequest tableRequest = dynamoDBMapper
                .generateCreateTableRequest(FeedbackInfo.class);
        tableRequest.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableRequest);

    }

    @Test
    public void saveAndGetTestInFeedbackInfo() {
        FeedbackInfo feedbackInfo = new FeedbackInfo(1001);
        List<String> feedbackList = new ArrayList();
        feedbackList.add("Quick Learner");
        feedbackList.add("Team Player");
        feedbackInfo.setFeedbackReport(feedbackList);
        feedbackController.saveFeedback(feedbackInfo.toString());
        List<String> l1 =  feedbackController.getFeedbacks(1001);
        Assert.assertTrue(l1.size() > 0);

    }
}
