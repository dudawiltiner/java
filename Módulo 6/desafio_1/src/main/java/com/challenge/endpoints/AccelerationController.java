package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.interfaces.AccelerationServiceInterface;
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
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationServiceInterface accelerationServiceInterface;

    @GetMapping
    public ResponseEntity<List<Acceleration>> findByCompanyId(@PathParam("companyId") Long companyId) {
        List<Acceleration> accelerations = this.accelerationServiceInterface.findByCompanyId(companyId);
        if (accelerations.size() != 0) {
            return new ResponseEntity<>(accelerations, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acceleration> findById(@PathVariable("id") Long id){
        Optional<Acceleration> acceleration = this.accelerationServiceInterface.findById(id);
        // trantando a variável Optional
        return acceleration.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE));
    }

}