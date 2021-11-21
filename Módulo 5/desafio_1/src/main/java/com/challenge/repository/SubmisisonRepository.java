package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface SubmisisonRepository extends CrudRepository<Submission, Long> {
    @Query(value="select MAX(submission.score) from challenge " +
            "INNER JOIN submission " +
            "ON challenge.id = submission.challenge_id " +
            "where challenge.id = :challengeId ", nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query(value="select * from CHALLENGE challenge " +
            "INNER JOIN SUBMISSION submission " +
            "ON submission.challenge_id = challenge.id " +
            "INNER JOIN ACCELERATION acceleration " +
            "ON acceleration.challenge_id = challenge.id " +
            "where challenge.id = :challengeId and " +
            "acceleration.id = :accelerationId", nativeQuery = true)
    List<Submission> findByChallegeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);
}
