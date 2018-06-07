package com.cal.bloggit.accessors;

import com.cal.bloggit.domains.DomainBookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookmarkAccessor extends JpaRepository<DomainBookmark, Long> {

    List<DomainBookmark> findByVisibleTrue();

    List<DomainBookmark> findAllByOrderByPriorityDesc();


}
