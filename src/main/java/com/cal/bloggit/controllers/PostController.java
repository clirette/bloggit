package com.cal.bloggit.controllers;

import com.cal.bloggit.domains.DomainPost;
import com.cal.bloggit.managers.IPostManager;
import com.cal.bloggit.views.ViewPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    IPostManager postManager;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ViewPost>> getAllPosts() {
        return new ResponseEntity<>(postManager.getAllPosts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    ResponseEntity<ViewPost> getPost(@PathVariable Long postId) {
        return new ResponseEntity<>(postManager.getPostById(postId), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<List<ViewPost>> getPostsByDate(
            @RequestParam("startDate") Long startDate,
            @RequestParam("endDate") Long endDate) {
        return new ResponseEntity<>(postManager.getPostsByDate(startDate, endDate), HttpStatus.OK);    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<ViewPost> createPost(@RequestBody ViewPost domainPost) {
        return new ResponseEntity<>(postManager.createPost(domainPost), HttpStatus.OK);
    }

    @RequestMapping(value = "/{postId}", method = RequestMethod.PUT)
    ResponseEntity<ViewPost> updatePost(@PathVariable Long postId, @RequestBody ViewPost domainPost) {
        return new ResponseEntity<>(postManager.updatePost(postId, domainPost), HttpStatus.OK);
    }

    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    ResponseEntity<ViewPost> deletePost(@PathVariable Long postId) {
        return new ResponseEntity<>(postManager.deletePost(postId), HttpStatus.OK);
    }
}
