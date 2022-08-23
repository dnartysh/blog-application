package org.blogio.java.service;

import org.blogio.java.api.response.TagResponse;
import org.blogio.java.api.response.model.TagResponseModel;
import org.blogio.java.model.Tag;
import org.blogio.java.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {
    private TagRepository tagRepository;
    private TagResponse tagResponse;

    public TagService(TagRepository tagRepository, TagResponse tagResponse) {
        this.tagRepository = tagRepository;
        this.tagResponse = tagResponse;
    }

    public TagResponse getTags(String tag) {
        if (!"".equals(tag)) {
            tagResponse.setTags(getTagsForTagResponse(tagRepository.findTagsByTagName(tag)));
        } else {
            tagResponse.setTags(getTagsForTagResponse(tagRepository.findAll()));
        }

        return tagResponse;
    }

    private List<TagResponseModel> getTagsForTagResponse(List<Tag> tags) {
        List<TagResponseModel> tagResponseModels = new ArrayList<>();

        tags.forEach(tag -> tagResponseModels.add(new TagResponseModel(tag.getName(), tag.getId())));

        return tagResponseModels;
    }

    private List<TagResponseModel> getTagsForTagResponse(Iterable<Tag> tags) {
        List<TagResponseModel> tagResponseModels = new ArrayList<>();

        tags.forEach(tag -> tagResponseModels.add(new TagResponseModel(tag.getName(), tag.getId())));

        return tagResponseModels;
    }

    private double getDiffWeight() {
        return 0;
    }
}
