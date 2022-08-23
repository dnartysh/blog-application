package org.blogio.java.api.response;

import lombok.Getter;
import lombok.Setter;
import org.blogio.java.api.response.model.TagResponseModel;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@Getter
@Setter
public class TagResponse {
    private List<TagResponseModel> tags;

    public TagResponse() {
        this.tags = new ArrayList<>();
    }

    public TagResponse(List<TagResponseModel> tags) {
        this.tags = tags;
    }
}
