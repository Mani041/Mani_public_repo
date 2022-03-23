package com.example.FeedBackApp.repository;

import com.example.FeedBackApp.entity.FeedbackInfo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface FeedbackInfoRepository extends CrudRepository<FeedbackInfo, Integer> {
    Optional<FeedbackInfo> findById(Integer empId);

}
