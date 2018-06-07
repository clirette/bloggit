import { Component } from '@angular/core';
import { Post } from '../post-service/post';
import { PostService } from '../post-service/post.service';
import { HttpErrorResponse } from '@angular/common/http';
import {
   Router,
   ActivatedRoute
} from '@angular/router';

@Component({
   selector: 'post-form',
   templateUrl: 'post-form.component.html',
   styleUrls: ['post-form.component.css']
})
export class PostFormComponent { 
	private post: Post;
	private postService: PostService;
	private postId: number;
	private router: Router;
	private error: HttpErrorResponse;

	constructor(router: Router, route: ActivatedRoute, postService: PostService) {
		this.router = router;
		this.postService = postService;
	    this.post = new Post();
	    route.params.subscribe(params => this.postId = params['postId']);
	    if (this.postId) {
	        postService.getPostById(this.postId).subscribe(
		        (post) => this.post = post,
	    	    (error) => this.error = error
	           );
	    } else {
	        this.post = new Post();
	    }
	}

	submitPost() {
       if (this.postId) {
           this.postService.updatePost(this.postId, this.post)
               .subscribe(
                   (post) => this.router.navigate(['posts', this.postId]),
                   (error) => this.error = error
               );
       } else {
           this.postService.createPost(this.post)
               .subscribe(
                   (post) => this.router.navigate(['posts']),
                   (error) => this.error = error
           );
       }
   }
}