package org.blogio.java.api.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
@Getter
@Setter
public class CheckResponse {
    private boolean result = false;
}
