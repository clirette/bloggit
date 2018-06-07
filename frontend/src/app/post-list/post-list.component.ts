import { Component } from '@angular/core';
import { PostService } from '../post-service/post.service';
import { Post } from '../post-service/post';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
   selector: 'post-list',
   templateUrl: 'post-list.component.html',
   styleUrls: ['post-list.component.css']
})
// export class PostListComponent {}
export class PostListComponent {
	private error: HttpErrorResponse;
   private posts: Post[];
   private postService: PostService;

    constructor(postService: PostService) {
      postService.getAllPosts().subscribe(posts => { 
      		this.posts = posts;
            this.postService = postService;
      	},
      	error => {
      		this.error = error;
      	});
   }

   deletePostsFromList(postId: number) {
       const index: number = this.posts
            .findIndex((post) => post.postId === postId);
       this.posts.splice(index, 1);
   }

   handlePostDeleted(post: Post) {
      this.postService.deletePost(post.postId).subscribe(
            (post) => this.deletePostsFromList(post.postId),
            (error) => this.error = error
         )

   }

}