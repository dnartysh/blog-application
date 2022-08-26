package org.blogio.java.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
@Getter
@Setter
public class SettingsResponse {
    @JsonProperty("MULTIUSER_MODE")
    private boolean multiuserMode;
    @JsonProperty("POST_PREMODERATION")
    private boolean postPremoderation;
    @JsonProperty("STATISTICS_IS_PUBLIC")
    private boolean statisticsIsPublic;
}
