package com.cal.bloggit.managers.impl;

import com.cal.bloggit.accessors.IPostAccessor;
import com.cal.bloggit.converters.IPostConverter;
import com.cal.bloggit.domains.DomainPost;
import com.cal.bloggit.views.ViewPost;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class PostManagerTest {

    @Mock
    private IPostAccessor postAccessor;

    @Mock
    private IPostConverter postConverter;

    @InjectMocks
    private PostManager postManager;

    private ViewPost viewPost;
    private DomainPost domainPost;

    @Before
    public void setUp() throws Exception {
        domainPost = new DomainPost();
        viewPost = new ViewPost();
    }

    @Test
    public void getAllPosts() throws Exception {
        when(postAccessor.findAll())
                .thenReturn(Arrays.asList(domainPost));
        when(postConverter.domainToView(any(DomainPost.class)))
                .thenReturn(viewPost);
        List<ViewPost> results = postManager.getAllPosts();
        assertThat(results.size(), is(1));
        assertThat(results.get(0), is(viewPost));
    }

    @Test
    public void getPostById() throws Exception {
        when(postAccessor.findOne(anyLong()))
                .thenReturn(domainPost);
        when(postConverter.domainToView(any(DomainPost.class)))
                .thenReturn(viewPost);
        ViewPost response = postManager.getPostById(1L);
        assertThat(response, is(viewPost));
    }

    @Test(expected = EntityNotFoundException.class)
    public void getPostById_EntityNotFound() {
        when(postAccessor.findOne(anyLong())).thenReturn(null);
        postManager.getPostById(1L);
    }

    @Test
    public void createPost() throws Exception {
    }

    @Test
    public void updatePost() throws Exception {

    }

    @Test
    public void deletePost() {
        when(postAccessor.findOne(anyLong()))
                .thenReturn(domainPost);
        doNothing().when(postAccessor).delete(any(DomainPost.class));
        when(postConverter.domainToView(any(DomainPost.class)))
                .thenReturn(viewPost);
        ViewPost response = postManager.deletePost(1L);
        assertThat(response, is(viewPost));
    }

    @Test(expected = EntityNotFoundException.class)
    public void deletePost_EntityNotFound() {
        when(postAccessor.findOne(anyLong())).thenReturn(null);
        postManager.deletePost(1L);
    }

    @Test
    public void getPostsByDate() throws Exception {
    }

}