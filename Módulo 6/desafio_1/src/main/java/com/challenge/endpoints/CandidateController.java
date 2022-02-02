package com.challenge.endpoints;

import com.challenge.entity.Candidate;
import com.challenge.entity.Submission;
import com.challenge.entity.User;
import com.challenge.service.interfaces.CandidateServiceInterface;
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
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateServiceInterface candidateServiceInterface;

    @GetMapping
    public ResponseEntity<List<Candidate>> findAll(@PathParam("companyId") Long companyId) {
        List<Candidate> candidates = this.candidateServiceInterface.findByCompanyId(companyId);
        if(candidates.size() != 0){
            return new ResponseEntity<>(candidates, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public ResponseEntity<Candidate> findById(@PathVariable("userId") Long userId, @PathVariable("companyId") Long companyId, @PathVariable("accelerationId") Long accelerationId) {
        Optional<Candidate> candidate = this.candidateServiceInterface.findById(userId, companyId, accelerationId);
        return candidate.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE));
    }

}
