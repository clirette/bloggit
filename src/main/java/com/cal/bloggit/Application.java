package com.cal.bloggit;

import com.cal.bloggit.accessors.IBookmarkAccessor;
import com.cal.bloggit.accessors.IPostAccessor;
import com.cal.bloggit.domains.DomainBookmark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner startup(IPostAccessor postAccessor, IBookmarkAccessor bookmarkAccessor) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {

//                DomainBookmark domainBookmark = new DomainBookmark();
//                domainBookmark.setTitle("My new DomainBookmark");
//                domainBookmark.setUrl("www.google.com");
//                domainBookmark.setVisible(true);
//                domainBookmark.setPriority(5);
//                LOGGER.info("Created a new domainBookmark: {}", domainBookmark);
//                bookmarkAccessor.save(domainBookmark);
//
//                LOGGER.info("Visible bookmarks: " + bookmarkAccessor.findByVisibleTrue());
//                LOGGER.info("Sorted by priority: " + bookmarkAccessor.findAllByOrderByPriorityDesc());
            }
        };
    }
}
