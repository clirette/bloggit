package com.cal.bloggit.engines.impl;

import com.cal.bloggit.engines.IBookmarkEngine;
import com.cal.bloggit.views.ViewBookmark;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookmarkEngineTest {

    IBookmarkEngine bookmarkEngine = new BookmarkEngine();

    private ViewBookmark defaultBookmark;

    @Before
    public void setUp() throws Exception {
        defaultBookmark = new ViewBookmark();
        defaultBookmark.setBookmarkId(15L);
        defaultBookmark.setTitle("A test title");
        defaultBookmark.setUrl("www.unittesturl.com");
        defaultBookmark.setVisible(true);
        defaultBookmark.setPriority(8);
    }

    @Test
    public void getFullUrl() throws Exception {
        String fullUrl = bookmarkEngine.getFullUrl(defaultBookmark.getUrl());
        String testUrl = "http://www.unittesturl.com";
        assertTrue(fullUrl.equals(testUrl));
        String prefix = "http://";
        assertTrue(fullUrl.substring(0,7).equals(prefix));
    }

}