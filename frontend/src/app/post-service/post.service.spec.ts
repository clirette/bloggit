import { TestBed, inject } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { PostService } from './post.service';
import { Post } from './post';
import {
   HttpClientTestingModule,
   HttpTestingController
} from '@angular/common/http/testing';

describe('PostService', function() {
	let postService: PostService;
    let mockBackend: HttpTestingController;
    let posts: Post[];
   	let error: ErrorEvent;


	beforeEach(function() {
    	TestBed.configureTestingModule({
       		imports: [
       			HttpClientModule,
       			HttpClientTestingModule
       		],
        	providers: [PostService]
        });
    });

    beforeEach(inject([PostService, HttpTestingController], 
    	function(_postService_, _mockBackend_) {
    	postService = _postService_;
        mockBackend = _mockBackend_;
    }));

    beforeEach(function() {
       posts = [new Post(), new Post(), new Post()];
       error = new ErrorEvent("Error");
    });

    it('should make a GET request', function() {
    	postService.getAllPosts().subscribe();
    	mockBackend
        	.expectOne({
               url: 'http://localhost:8080/api/v1/post',
               method: 'GET'
            });
    });

    it('should make a GET request and return a list of posts', function() {
       postService.getAllPosts().subscribe(
           response => {
               expect(response.length).toEqual(3);
               expect(response).toBe(posts);
           },
           response => fail()
       );

       mockBackend
           .expectOne({
               url: 'http://localhost:8080/api/v1/post',
               method: 'GET'
           })
           .flush(posts);
    });

    it('should make a GET request and return an error', function() {
       postService.getAllPosts().subscribe(
           response => fail(),
           response => expect(response.error).toBe(error)
       );
       mockBackend
           .expectOne({
               url: 'http://localhost:8080/api/v1/post',
               method: 'GET'
           })
           .error(error);
    });

});