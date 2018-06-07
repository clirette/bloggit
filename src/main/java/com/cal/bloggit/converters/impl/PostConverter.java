package com.cal.bloggit.converters.impl;

import com.cal.bloggit.converters.ILocalDateTimeConverter;
import com.cal.bloggit.converters.IPostConverter;
import com.cal.bloggit.domains.DomainPost;
import com.cal.bloggit.engines.IPostEngine;
import com.cal.bloggit.views.ViewPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostConverter implements IPostConverter{

    @Autowired
    private ILocalDateTimeConverter localDateTimeConverter;

    @Autowired
    private IPostEngine postEngine;

    @Override
    public DomainPost viewToDomain(ViewPost viewPost) {
        DomainPost domainPost = new DomainPost();
        domainPost.setPostId(viewPost.getPostId());
        domainPost.setTitle(viewPost.getTitle());
        domainPost.setBody(viewPost.getBody());
        domainPost.setAuthor(viewPost.getAuthor());

        LocalDateTime now = LocalDateTime.now();
        domainPost.setLastUpdated(now);

        if (viewPost.getPostId() == null) {
            domainPost.setCreatedOn(now);
        } else {
            domainPost.setCreatedOn(localDateTimeConverter
                    .convertLongToLocalDateTime(viewPost.getCreatedOn()));
        }
        return domainPost;
    }

    @Override
    public ViewPost domainToView(DomainPost domainPost) {
        ViewPost viewPost = new ViewPost();
        viewPost.setPostId(domainPost.getPostId());
        viewPost.setTitle(domainPost.getTitle());
        viewPost.setBody(domainPost.getBody());
        viewPost.setAuthor(domainPost.getAuthor());
        viewPost.setLastUpdated(localDateTimeConverter
                .convertLocalDateTimeToLong(domainPost.getLastUpdated()));
        viewPost.setCreatedOn(localDateTimeConverter
                .convertLocalDateTimeToLong(domainPost.getCreatedOn()));
        viewPost.setSummary(postEngine.getSummaryText(domainPost.getBody()));
        return viewPost;
    }
}