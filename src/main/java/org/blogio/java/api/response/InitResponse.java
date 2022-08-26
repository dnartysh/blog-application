package org.blogio.java.api.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
@Getter
@Setter
public class InitResponse {
    @Value("${blogio.title}")
    private String title;
    @Value("${blogio.subtitle}")
    private String subtitle;
    @Value("${blogio.phone}")
    private String phone;
    @Value("${blogio.email}")
    private String email;
    @Value("${blogio.copyright}")
    private String copyright;
    @Value("${blogio.copyrightFrom}")
    private String copyrightFrom;
}
