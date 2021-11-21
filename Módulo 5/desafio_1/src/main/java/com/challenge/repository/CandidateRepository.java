package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {
    Optional<Candidate> findById(CandidateId id);

    @Query(value="select * from cadidate " +
            "where candidate.user_id = :userId and " +
            "candidate.company_id = :companyId and " +
            "candidate.acceleration_id = :accelerationId", nativeQuery = true)
    Optional<Candidate> findById(@Param("userId") Long userId, @Param("companyId") Long companyId, @Param("accelerationId") Long accelerationId);

    @Query(value="select * from candidate " +
            "where candidate.acceleration_id = :accelerationId", nativeQuery = true)
    List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId);

    @Query(value="select * from candidate " +
            "INNER JOIN company " +
            "ON candidate.company_id = company.id " +
            "where company.id = :companyId", nativeQuery = true)
    List<Candidate> findByCompanyId(@Param("companyId") Long companyId);
}

