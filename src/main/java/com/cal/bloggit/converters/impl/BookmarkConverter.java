package com.cal.bloggit.converters.impl;

import com.cal.bloggit.converters.IBookmarkConverter;
import com.cal.bloggit.converters.ILocalDateTimeConverter;
import com.cal.bloggit.domains.DomainBookmark;
import com.cal.bloggit.engines.IBookmarkEngine;
import com.cal.bloggit.views.ViewBookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookmarkConverter implements IBookmarkConverter {

    @Autowired
    private ILocalDateTimeConverter localDateTimeConverter;
    @Autowired
    private IBookmarkEngine bookmarkEngine;

    @Override
    public DomainBookmark viewToDomain(ViewBookmark viewBookmark) {
        DomainBookmark domainBookmark = new DomainBookmark();
        domainBookmark.setBookmarkId(viewBookmark.getBookmarkId());
        domainBookmark.setTitle(viewBookmark.getTitle());
//        domainBookmark.setUrl(viewBookmark.getUrl());
        domainBookmark.setUrl(bookmarkEngine.getFullUrl(viewBookmark.getUrl()));
        domainBookmark.setVisible(viewBookmark.isVisible());
        domainBookmark.setPriority(viewBookmark.getPriority());

        LocalDateTime now = LocalDateTime.now();
        domainBookmark.setLastUpdated(now);

        return domainBookmark;
    }

    @Override
    public ViewBookmark domainToView(DomainBookmark domainBookmark) {
        ViewBookmark viewBookmark = new ViewBookmark();
        viewBookmark.setBookmarkId(domainBookmark.getBookmarkId());
        viewBookmark.setTitle(domainBookmark.getTitle());
//        viewBookmark.setUrl(domainBookmark.getUrl());
        viewBookmark.setUrl(bookmarkEngine.getFullUrl(domainBookmark.getUrl()));
        viewBookmark.setVisible(domainBookmark.isVisible());
        viewBookmark.setPriority(domainBookmark.getPriority());
        viewBookmark.setLastUpdated(localDateTimeConverter
                .convertLocalDateTimeToLong(domainBookmark.getLastUpdated()));
        return viewBookmark;
    }
}
