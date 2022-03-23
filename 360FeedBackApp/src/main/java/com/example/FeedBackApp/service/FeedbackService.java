package com.example.FeedBackApp.service;

import com.example.FeedBackApp.model.FeedBackModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedbackService {

    void saveFeedback(FeedBackModel feedBackModel);

    List<String> getFeedbacks(Integer id);
}

