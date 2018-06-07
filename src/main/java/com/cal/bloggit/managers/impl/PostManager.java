package com.cal.bloggit.managers.impl;

import com.cal.bloggit.accessors.IPostAccessor;
import com.cal.bloggit.converters.ILocalDateTimeConverter;
import com.cal.bloggit.converters.IPostConverter;
import com.cal.bloggit.domains.DomainPost;
import com.cal.bloggit.managers.IPostManager;
import com.cal.bloggit.views.ViewPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostManager implements IPostManager {

    @Autowired
    private IPostAccessor postAccessor;
    @Autowired
    private ILocalDateTimeConverter localDateTimeConverter;
    @Autowired
    private IPostConverter postConverter;

    @Override
    public List<ViewPost> getAllPosts() {
        return postAccessor.findAll().stream()
                .map(postConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewPost getPostById(Long postId) {
        DomainPost domainPost = postAccessor.findOne(postId);
        if (domainPost == null)
            throw new EntityNotFoundException("Unable to retrieve post: " + postId.toString());
        return postConverter.domainToView(domainPost);
    }

    @Override
    public ViewPost createPost(ViewPost viewPost) {

        return postConverter.domainToView(postAccessor.save(postConverter.viewToDomain(viewPost)));
    }

    @Override
    public ViewPost updatePost(Long postId, ViewPost viewPost) {
        DomainPost currentDomainPost = postAccessor.findOne(postId);
        if (currentDomainPost == null)
            throw new EntityNotFoundException("Unable to retrieve post: " + postId.toString());
        else if (!viewPost.getPostId().equals(postId))
            throw new InvalidParameterException("Provided post id: " + postId + " does not match provided post: " + viewPost);
        return postConverter.domainToView(postAccessor.save(postConverter.viewToDomain(viewPost)));
    }

    @Override
    public ViewPost deletePost(Long postId) {
        DomainPost domainPost = postAccessor.findOne(postId);
        if (domainPost == null) {
            throw new EntityNotFoundException("Unable to retrieve post: " + postId.toString());
        }
        postAccessor.delete(postId);
        return postConverter.domainToView(domainPost);
    }

    @Override
    public List<ViewPost> getPostsByDate(Long startDate, Long endDate) {
        LocalDateTime ldtStartDate = localDateTimeConverter.convertLongToLocalDateTime(startDate);
        LocalDateTime ldtEndDate = localDateTimeConverter.convertLongToLocalDateTime(endDate);
        return postAccessor.findAllByCreatedOnAfterAndCreatedOnBefore(ldtStartDate, ldtEndDate).stream()
                .map(postConverter::domainToView)
                .collect(Collectors.toList());
    }
}
