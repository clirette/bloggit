package com.cal.bloggit.managers;


import com.cal.bloggit.views.ViewBookmark;

import java.util.List;

public interface IBookmarkManager {
    List<ViewBookmark> getAllBookmarks();

    ViewBookmark getBookmarkById(Long bookmarkId);

    //List<ViewBookmark> findByVisibleTrue();

    List<ViewBookmark> getVisibleBookmarks();

    ViewBookmark createBookmark(ViewBookmark ViewBookmark);

    ViewBookmark updateBookmark(Long bookmarkId, ViewBookmark ViewBookmark);

    ViewBookmark deleteBookmark(Long bookmarkId);

}
