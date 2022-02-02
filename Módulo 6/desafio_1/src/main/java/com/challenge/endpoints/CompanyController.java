package com.challenge.endpoints;


import com.challenge.entity.Company;
import com.challenge.entity.User;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServiceInterface companyServiceInterface;

    @GetMapping
    public ResponseEntity<List<Company>> findByType(@PathParam("accelerationId") Long accelerationId, @PathParam("userId") Long userId) {
        if(accelerationId != null){
            return findByAccelerationId(accelerationId);
        } else {
            return findByUserId(userId);
        }

    }

    public ResponseEntity<List<Company>> findByAccelerationId(Long accelerationId){
        List<Company> companies = this.companyServiceInterface.findByAccelerationId(accelerationId);

        if(companies.size() != 0){
            return new ResponseEntity<>(companies, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Company>> findByUserId(Long userId){
        List<Company> companies = this.companyServiceInterface.findByUserId(userId);

        if(companies.size() != 0){
            return new ResponseEntity<>(companies, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable("id") Long id){
        Optional<Company> company = this.companyServiceInterface.findById(id);
        // trantando a variável Optional
        return company.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE));
    }
}
