package com.cal.bloggit.controllers;

import com.cal.bloggit.managers.IBookmarkManager;
import com.cal.bloggit.views.ViewBookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookmark")
public class BookmarkController {

    @Autowired
    private IBookmarkManager bookmarkManager;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ViewBookmark>> getAllBookmarks() {
        return new ResponseEntity<>(bookmarkManager.getAllBookmarks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{bookmarkId}", method = RequestMethod.GET)
    ResponseEntity<ViewBookmark> getBookmark(@PathVariable Long bookmarkId) {
        return new ResponseEntity<>(bookmarkManager.getBookmarkById(bookmarkId), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<List<ViewBookmark>> getVisibleBookmarks(
            @RequestParam("isVisible") boolean isVisible
    ) {
        return new ResponseEntity<>(bookmarkManager.getVisibleBookmarks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<ViewBookmark> createBookmark(@RequestBody ViewBookmark Viewbookmark) {
        return new ResponseEntity<>(bookmarkManager.createBookmark(Viewbookmark), HttpStatus.OK);
    }

    @RequestMapping(value = "/{bookmarkId}", method = RequestMethod.PUT)
    ResponseEntity<ViewBookmark> updateBookmark(@PathVariable Long bookmarkId, @RequestBody ViewBookmark Viewbookmark) {
        return new ResponseEntity<>(bookmarkManager.updateBookmark(bookmarkId, Viewbookmark), HttpStatus.OK);
    }

    @RequestMapping(value = "/{bookmarkId}", method = RequestMethod.DELETE)
    ResponseEntity<ViewBookmark> deleteBookmark(@PathVariable Long bookmarkId) {
        return new ResponseEntity<>(bookmarkManager.deleteBookmark(bookmarkId), HttpStatus.OK);
    }
}
