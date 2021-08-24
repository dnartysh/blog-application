package org.blogio.java.api.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
@Getter
@Setter
public class UserResponse {
    public UserResponse() {}

    public UserResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;
}
