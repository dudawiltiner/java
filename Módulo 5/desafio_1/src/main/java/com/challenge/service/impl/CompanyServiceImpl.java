package com.challenge.service.impl;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyServiceInterface {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Optional<Company> findById(Long id) {
        return this.companyRepository.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        return this.companyRepository.findByAccelerationId(accelerationId);
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return this.companyRepository.findByUserId(userId);
    }

    @Override
    public Company save(Company object) {
        return this.companyRepository.save(object);
    }
}
