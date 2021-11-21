package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long id);

    @Query(value="select * from candidate " +
            "INNER JOIN users " +
            "ON users.id = candidate.user_id " +
            "INNER JOIN acceleration " +
            "ON candidate.acceleration_id = acceleration.id " +
            "where acceleration.name = :accelerationName", nativeQuery = true)
    List<User> findByAccelerationName(@Param("accelerationName") String accelerationName);

    @Query(value="select * from candidate " +
            "INNER JOIN users " +
            "ON users.id = candidate.user_id " +
            "INNER JOIN company " +
            "ON candidate.company_id = company.id " +
            "where company.id = :companyId", nativeQuery = true)
    List<User> findByCompanyId(@Param("companyId") Long companyId);
}
