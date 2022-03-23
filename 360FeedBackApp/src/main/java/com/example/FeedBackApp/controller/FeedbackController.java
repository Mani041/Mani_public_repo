package com.example.FeedBackApp.controller;

import com.example.FeedBackApp.model.FeedBackModel;
import com.example.FeedBackApp.service.FeedbackService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    protected final Logger LOGGER = LoggerFactory.getLogger( this.getClass() );

    @Autowired
    FeedbackService feedbackService;

    private ObjectMapper objectMapper;


    @PostMapping("/savefeedback")
    public void saveFeedback(@Validated @RequestBody String feedbackObj) {
        LOGGER.info("Entering into saveFeedback method:");
        try {
            FeedBackModel feedBackModel = objectMapper.readValue(feedbackObj, FeedBackModel.class);
            feedbackService.saveFeedback(feedBackModel);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error inside SaveFeedback method: " + e.getMessage());
        } catch (Exception exception) {
            LOGGER.error("Error inside SaveFeedback method: " + exception.getMessage());
        }

    }

    @GetMapping("/getfeedbacks/{id}")
    public List<String> getFeedbacks(@PathVariable Integer id) {
        LOGGER.info("Entering into getFeedbacks method:");
        List<String> feedbacks = null;
        try {
            feedbacks = feedbackService.getFeedbacks(id);
        } catch (Exception e) {
            LOGGER.error("Error inside getFeedbacks method: " + e.getMessage());
        }
        return feedbacks;
    }

}
