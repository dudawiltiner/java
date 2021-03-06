package com.challenge.service.impl;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccelerationServiceImpl implements AccelerationServiceInterface {
    @Autowired
    private AccelerationRepository accelerationRepository;

    @Override
    public Optional<Acceleration> findById(Long id) {
        return this.accelerationRepository.findById(id);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return this.accelerationRepository.findByCompanyId(companyId);
    }

    @Override
    public Acceleration save(Acceleration object) {
        return this.accelerationRepository.save(object);
    }
}
