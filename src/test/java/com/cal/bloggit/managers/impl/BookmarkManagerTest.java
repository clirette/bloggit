package com.cal.bloggit.managers.impl;

import com.cal.bloggit.accessors.IBookmarkAccessor;
import com.cal.bloggit.converters.IBookmarkConverter;
import com.cal.bloggit.domains.DomainBookmark;
import com.cal.bloggit.views.ViewBookmark;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookmarkManagerTest {

    @Mock
    private IBookmarkAccessor bookmarkAccessor;

    @Mock
    private IBookmarkConverter bookmarkConverter;

    @InjectMocks
    private BookmarkManager bookmarkManager;

    private ViewBookmark viewBookmark;
    private DomainBookmark domainBookmark;

    @Before
    public void setUp() throws Exception {
        domainBookmark = new DomainBookmark();
        viewBookmark = new ViewBookmark();
    }

    @Test
    public void getAllBookmarks() throws Exception {
        when(bookmarkAccessor.findAll())
                .thenReturn(Arrays.asList(domainBookmark));
        when(bookmarkConverter.domainToView(any(DomainBookmark.class)))
                .thenReturn(viewBookmark);
        List<ViewBookmark> results = bookmarkManager.getAllBookmarks();
        assertThat(results.size(), is(1));
        assertThat(results.get(0), is(viewBookmark));
    }

    @Test
    public void getBookmarkById() throws Exception {
        when(bookmarkAccessor.findOne(anyLong()))
                .thenReturn(domainBookmark);
        when(bookmarkConverter.domainToView(any(DomainBookmark.class)))
                .thenReturn(viewBookmark);
        ViewBookmark response = bookmarkManager.getBookmarkById(1L);
        assertThat(response, is(viewBookmark));
    }

    @Test(expected = EntityNotFoundException.class)
    public void getBookmarkById_EntityNotFound() {
        when(bookmarkAccessor.findOne(anyLong())).thenReturn(null);
        bookmarkManager.getBookmarkById(1L);
    }

    @Test
    public void getVisibleBookmarks() throws Exception {
    }

    @Test
    public void createBookmark() throws Exception {
    }

    @Test
    public void updateBookmark() throws Exception {
    }

    @Test
    public void deleteBookmark() throws Exception {
        when(bookmarkAccessor.findOne(anyLong()))
                .thenReturn(domainBookmark);
        doNothing().when(bookmarkAccessor).delete(any(DomainBookmark.class));
        when(bookmarkConverter.domainToView(any(DomainBookmark.class)))
                .thenReturn(viewBookmark);
        ViewBookmark response = bookmarkManager.deleteBookmark(1L);
        assertThat(response, is(viewBookmark));
    }

    @Test(expected = EntityNotFoundException.class)
    public void deletePost_EntityNotFound() {
        when(bookmarkAccessor.findOne(anyLong())).thenReturn(null);
        bookmarkManager.deleteBookmark(1L);
    }

}