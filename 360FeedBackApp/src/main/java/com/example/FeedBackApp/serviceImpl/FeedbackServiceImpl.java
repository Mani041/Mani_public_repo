package com.example.FeedBackApp.serviceImpl;

import com.example.FeedBackApp.entity.FeedbackInfo;
import com.example.FeedBackApp.model.FeedBackModel;
import com.example.FeedBackApp.repository.FeedbackInfoRepository;
import com.example.FeedBackApp.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackInfoRepository repository;

    @Override
    public void saveFeedback(FeedBackModel feedBackModel) {
        Optional<FeedbackInfo> feedbackInfo = repository.findById(feedBackModel.getEmpId());
        FeedbackInfo feedbackInfo1 = null;
        List<String> feedbackList = null;
        if(feedbackInfo.isEmpty()) {
             feedbackInfo1 = new FeedbackInfo(feedBackModel.getEmpId());
             feedbackList = new ArrayList();
        } else {
             feedbackInfo1 = feedbackInfo.get();
             feedbackList = feedbackInfo1.getFeedbackReport();
        }
        feedbackList.add(feedBackModel.getFeedback());
        feedbackInfo1.setFeedbackReport(feedbackList);
        repository.save(feedbackInfo1);
    }

    @Override
    public List<String> getFeedbacks(Integer id) {
        Optional<FeedbackInfo> feedbackInfo = repository.findById(id);
        return feedbackInfo.isEmpty() ?  null : feedbackInfo.get().getFeedbackReport();
    }
}
