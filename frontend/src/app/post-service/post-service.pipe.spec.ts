import { PostSortPipe } from './post-sort.pipe';
import { Post } from './post';

describe('PostSortPipe', function() {

	let pipe: PostSortPipe;
    let post1: Post;
    let post2: Post;
    let post3: Post;

    beforeEach(function() {
       pipe = new PostSortPipe();
       post1 = new Post();
       post1.title = "Post 1";
       post2 = new Post();
       post2.title = "Post 2";
       post3 = new Post();
       post3.title = "Post 3";
    });

    it('properly sorts the post list', function() {
       let posts: Post[] = [post2, post3, post1];
       let output: Post[] = pipe.transform(posts);
       expect(output[0]).toBe(post1);
       expect(output[1]).toBe(post2);
       expect(output[2]).toBe(post3);
    });

    it('properly sorts with the ascending parameter', function() {
       let posts: Post[] = [post2, post3, post1];
       let output: Post[] = pipe.transform(posts, 'asc');
       expect(output[0]).toBe(post3);
       expect(output[1]).toBe(post2);
       expect(output[2]).toBe(post1);
    });	

    it('properly sorts with a bad parameter', function() {
       let posts: Post[] = [post2, post3, post1];
       let output: Post[] = pipe.transform(posts, 'bad');
       expect(output[0]).toBe(post1);
       expect(output[1]).toBe(post2);
       expect(output[2]).toBe(post3);
    });

});