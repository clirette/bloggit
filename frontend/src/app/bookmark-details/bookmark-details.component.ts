import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookmarkService } from '../bookmark-service/bookmark.service';
import { Bookmark } from '../bookmark-service/bookmark';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
   selector: 'bookmark-details',
   templateUrl: './bookmark-details.component.html',
   styleUrls: ['./bookmark-details.component.css']
})
export class BookmarkDetailsComponent {

	private bookmarkId: number;
	private bookmark: Bookmark;
	private error: HttpErrorResponse;

	constructor(route: ActivatedRoute, bookmarkService: BookmarkService) {
	    route.params.subscribe(params => this.bookmarkId = params['bookmarkId']);
	    bookmarkService.getBookmarkById(this.bookmarkId).subscribe(
	    	bookmark => this.bookmark = bookmark,
	    	error => this.error = error
	    );

	}

}