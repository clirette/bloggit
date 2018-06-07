package com.cal.bloggit.engines.impl;

import com.cal.bloggit.engines.IPostEngine;
import org.springframework.stereotype.Service;

@Service
public class PostEngine implements IPostEngine {

    private static final Integer SUMMARY_LENGTH = 256;

    @Override
    public String getSummaryText(String text) {
        if (text != null && text.length() > SUMMARY_LENGTH)
            return text.substring(0, SUMMARY_LENGTH);
        return text;
    }
}
