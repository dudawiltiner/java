package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceInterface userServiceInterface;

    @GetMapping
    public ResponseEntity<List<User>> findByType(@PathParam("accelerationName") String accelerationName, @PathParam("companyId") Long companyId) {
        if(!accelerationName.isEmpty()){
            return findByAccelerationName(accelerationName);
        } else {
            return findByCompanyId(companyId);
        }
    }

    public ResponseEntity<List<User>> findByAccelerationName(String accelerationName){
        List<User> users = this.userServiceInterface.findByAccelerationName(accelerationName);
        if(users.size() != 0){
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<User>> findByCompanyId(Long companyId){
        List<User> users = new ArrayList<>();
        if(companyId != null) {
            users = this.userServiceInterface.findByCompanyId(companyId);
        }
        if(users.size() != 0){
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
        Optional<User> user = this.userServiceInterface.findById(id);
        // trantando a variável Optional
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE));
    }
}
