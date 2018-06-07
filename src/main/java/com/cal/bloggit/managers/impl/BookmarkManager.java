package com.cal.bloggit.managers.impl;

import com.cal.bloggit.accessors.IBookmarkAccessor;
import com.cal.bloggit.converters.IBookmarkConverter;
import com.cal.bloggit.converters.ILocalDateTimeConverter;
import com.cal.bloggit.domains.DomainBookmark;
import com.cal.bloggit.managers.IBookmarkManager;
import com.cal.bloggit.views.ViewBookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookmarkManager implements IBookmarkManager{

    @Autowired
    private IBookmarkAccessor bookmarkAccessor;
    @Autowired
    private ILocalDateTimeConverter localDateTimeConverter;
    @Autowired
    private IBookmarkConverter bookmarkConverter;

    @Override
    public List<ViewBookmark> getAllBookmarks() {
        return bookmarkAccessor.findAll().stream()
                .map(bookmarkConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewBookmark getBookmarkById(Long bookmarkId) {
        DomainBookmark domainBookmark = bookmarkAccessor.findOne(bookmarkId);
        if (domainBookmark == null)
            throw new EntityNotFoundException("Unable to retrieve bookmark: " + bookmarkId.toString());
        return bookmarkConverter.domainToView(domainBookmark);
    }

    @Override
    public List<ViewBookmark> getVisibleBookmarks() {

        return bookmarkAccessor.findByVisibleTrue().stream()
                .map(bookmarkConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewBookmark createBookmark(ViewBookmark viewBookmark) {
        return bookmarkConverter.domainToView(bookmarkAccessor.save(bookmarkConverter.viewToDomain(viewBookmark)));
    }

    @Override
    public ViewBookmark updateBookmark(Long bookmarkId, ViewBookmark viewBookmark) {
        DomainBookmark currentDomainBookmark = bookmarkAccessor.findOne(bookmarkId);
        if (currentDomainBookmark == null)
            throw new EntityNotFoundException("Unable to retrieve bookmark: " + bookmarkId.toString());
        else if (!viewBookmark.getBookmarkId().equals(bookmarkId))
            throw new InvalidParameterException("Provided bookmark id: " + bookmarkId + " does not match provided bookmark " + viewBookmark);
        return bookmarkConverter.domainToView(bookmarkAccessor.save(bookmarkConverter.viewToDomain(viewBookmark)));
    }

    @Override
    public ViewBookmark deleteBookmark(Long bookmarkId) {
        DomainBookmark domainBookmark = bookmarkAccessor.findOne(bookmarkId);
        if (domainBookmark == null)
            throw new EntityNotFoundException("Unable to retrieve bookmark: " + bookmarkId.toString());
        bookmarkAccessor.delete(bookmarkId);
        return bookmarkConverter.domainToView(domainBookmark);
    }
}
