package com.n1b3lung0.gymrat.user.application.find;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.n1b3lung0.gymrat.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    private String id;
    private String username;
    private String email;
    private String firstName;
    private String lastName1;
    private String lastName2;

    public static UserResponse fromUser(User user) {
        return user != null ? new UserResponse(
                String.valueOf(user.getId()),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName1(),
                user.getLastName2()
        ) : new UserResponse();
    }
}
