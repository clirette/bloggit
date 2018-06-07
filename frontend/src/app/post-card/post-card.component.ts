import { 
		Component, 
		Input,
		Output,
   		EventEmitter 
} from '@angular/core';
import { Post } from '../post-service/post';
import { PostService } from '../post-service/post.service';
import { Router } from '@angular/router';

@Component({
   selector: 'post-card',
   templateUrl: 'post-card.component.html',
   styleUrls: ['post-card.component.css']
})
export class PostCardComponent { 
	private postService: PostService;
	private router: Router;

	@Output()
	private postDeleted: EventEmitter<Post>;

	@Input()
	private post: Post;

	constructor() {
       this.postDeleted = new EventEmitter<Post>();
    }

	updateTitle() {
       this.post.title += new Date();
   	}

   	deletePost() {
        this.postDeleted.emit(this.post);
    }
}