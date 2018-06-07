package com.cal.bloggit.converters;

import com.cal.bloggit.domains.DomainBookmark;
import com.cal.bloggit.views.ViewBookmark;

public interface IBookmarkConverter {
    DomainBookmark viewToDomain(ViewBookmark viewBookmark);

    ViewBookmark domainToView(DomainBookmark domainBookmark);
}
