package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.entity.User;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeServiceInterface challengeServiceInterface;

    @GetMapping
    public ResponseEntity<List<Challenge>> findByAccelerationIdAndUserId(@PathParam("accelerationId") Long accelerationId, @PathParam("userId") Long userId) {
        List<Challenge> challenges = this.challengeServiceInterface.findByAccelerationIdAndUserId(accelerationId, userId);
        if(challenges.size() != 0){
            return new ResponseEntity<>(challenges, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
