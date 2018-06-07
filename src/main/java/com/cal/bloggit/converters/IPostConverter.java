package com.cal.bloggit.converters;

import com.cal.bloggit.domains.DomainPost;
import com.cal.bloggit.views.ViewPost;

public interface IPostConverter {
    DomainPost viewToDomain(ViewPost viewPost);

    ViewPost domainToView(DomainPost domainPost);
}
