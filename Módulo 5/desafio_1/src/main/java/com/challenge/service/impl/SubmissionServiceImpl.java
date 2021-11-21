package com.challenge.service.impl;

import com.challenge.entity.Submission;
import com.challenge.repository.ChallengeRepository;
import com.challenge.repository.SubmisisonRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionServiceInterface {
    @Autowired
    private SubmisisonRepository submissionRepository;

    @Autowired
    private ChallengeRepository challengeRepository;


    @Override
    public Submission save(Submission object) {
        return this.submissionRepository.save(object);
    }

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        if(this.challengeRepository.findById(challengeId).isPresent()){
            return this.submissionRepository.findHigherScoreByChallengeId(challengeId);
        } else {
            return BigDecimal.ZERO;
        }
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return this.submissionRepository.findByChallegeIdAndAccelerationId(challengeId, accelerationId);
    }
}
