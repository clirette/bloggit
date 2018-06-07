package com.cal.bloggit.engines.impl;

import com.cal.bloggit.engines.IBookmarkEngine;
import org.springframework.stereotype.Service;

@Service
public class BookmarkEngine implements IBookmarkEngine{

    @Override
    public String getFullUrl(String url) {
        return "http://"+url;
    }
}
