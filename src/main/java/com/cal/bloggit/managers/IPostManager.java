package com.cal.bloggit.managers;

import com.cal.bloggit.views.ViewPost;

import java.util.List;

public interface IPostManager {

    List<ViewPost> getAllPosts();

    ViewPost getPostById(Long postId);

    ViewPost createPost(ViewPost ViewPost);

    ViewPost updatePost(Long postId, ViewPost ViewPost);

    ViewPost deletePost(Long postId);

    List<ViewPost> getPostsByDate(Long startDate, Long endDate);
}
