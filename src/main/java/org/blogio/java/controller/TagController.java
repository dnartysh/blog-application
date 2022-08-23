package org.blogio.java.controller;

import org.blogio.java.api.response.TagResponse;
import org.blogio.java.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tag")
public class TagController {
    private TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping()
    public TagResponse getTags(@RequestParam(required = false, defaultValue = "") String query) {
        return tagService.getTags(query);
    }
}
