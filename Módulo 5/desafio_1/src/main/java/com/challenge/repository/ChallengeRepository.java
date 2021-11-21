package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {
    @Query(value="select * from challenge " +
            "INNER JOIN acceleration " +
            "ON acceleration.challenge_id = challenge.id " +
            "INNER JOIN submission " +
            "ON challenge.id = submission.challenge_id " +
            "where submission.user_id = :userId and " +
            "acceleration.id = :accelerationId", nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId, @Param("userId") Long userId);
}
