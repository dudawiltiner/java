package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.entity.Submission;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionServiceInterface submissionServiceInterface;

    @GetMapping
    public ResponseEntity<List<Submission>> findByChallengeIdAndAccelerationId(@PathParam("accelerationId") Long accelerationId, @PathParam("challengeId") Long challengeId) {
        List<Submission> submissions = this.submissionServiceInterface.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
        if(submissions.size() != 0){
            return new ResponseEntity<>(submissions, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
