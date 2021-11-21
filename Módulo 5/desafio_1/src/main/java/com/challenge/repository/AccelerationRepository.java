package com.challenge.repository;


import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {
    Optional<Acceleration> findById(Long id);

    @Query(value="select * from candidate " +
            "INNER JOIN company " +
            "ON candidate.company_id = company.id " +
            "INNER JOIN acceleration " +
            "ON acceleration.id = candidate.acceleration_id " +
            "where company.id = :companyId", nativeQuery = true)
    List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);
}
