package org.blogio.java.service;

import org.blogio.java.api.response.TagResponse;
import org.blogio.java.api.response.model.TagResponseModel;
import org.blogio.java.model.Tag;
import org.blogio.java.repository.PostRepository;
import org.blogio.java.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {
    private TagRepository tagRepository;
    private PostRepository postRepository;
    private TagResponse tagResponse;

    public TagService(TagRepository tagRepository, PostRepository postRepository,
                      TagResponse tagResponse) {
        this.tagRepository = tagRepository;
        this.tagResponse = tagResponse;
        this.postRepository = postRepository;
    }

    public TagResponse getTags(String queryTag) {
        if (!"".equals(queryTag)) {
            tagResponse.setTags(getTagsForTagResponse(tagRepository.findTagsByTagName(queryTag + "%")));
        } else {
            tagResponse.setTags(getTagsForTagResponse(tagRepository.findAll()));
        }

        return tagResponse;
    }

    private List<TagResponseModel> getTagsForTagResponse(List<Tag> tags) {
        List<TagResponseModel> tagResponseModels = new ArrayList<>();

        tags.forEach(tag -> tagResponseModels.add(new TagResponseModel(tag.getName(), getDiffWeightForTag(tag))));

        return tagResponseModels;
    }

    private List<TagResponseModel> getTagsForTagResponse(Iterable<Tag> tags) {
        List<TagResponseModel> tagResponseModels = new ArrayList<>();

        tags.forEach(tag -> tagResponseModels.add(new TagResponseModel(tag.getName(), getDiffWeightForTag(tag))));

        return tagResponseModels;
    }

    private double getDiffWeightForTag(Tag tag) {
        double countPosts = postRepository.findCountPosts();
        double countPostsByTag = tagRepository.findCountPostsByTagId(tag.getId());
        Tag popularTag = tagRepository.findMostPopularTag();
        double countPostsByPopularTag = tagRepository.findCountPostsByTagId(popularTag.getId());

        double dWeight = countPostsByTag / countPosts;
        double dWeightMax = countPostsByPopularTag / countPosts;
        double k = 1 / dWeightMax;

        return dWeight * k;
    }
}
