package com.n1b3lung0.gymrat.user.rest;

import com.n1b3lung0.gymrat.common.base.rest.BaseRestController;
import com.n1b3lung0.gymrat.user.application.find.UserFinder;
import com.n1b3lung0.gymrat.user.application.find.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gymrat/users")
@RequiredArgsConstructor
public class UserController extends BaseRestController {

    private final UserFinder finder;

    public ResponseEntity<UserResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok(UserResponse.fromUser(finder.findById(id)));
    }

    public ResponseEntity<UserResponse> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(UserResponse.fromUser(finder.findByEmail(email)));
    }
}
