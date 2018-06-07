import { Component } from '@angular/core';
import { Bookmark } from '../bookmark-service/bookmark';
import { BookmarkService } from '../bookmark-service/bookmark.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
	selector: 'bookmark-form',
	templateUrl: 'bookmark-form.component.html',
	styleUrls: ['bookmark-form.component.css']
})
export class BookmarkFormComponent {
	private bookmark: Bookmark;
	private bookmarkId: number;
	private bookmarkService: BookmarkService;
	private error: HttpErrorResponse;
	private router: Router;

	constructor(router: Router, bookmarkService: BookmarkService, route: ActivatedRoute) {
		this.router = router;
		this.bookmarkService = bookmarkService;
		this.bookmark = new Bookmark();
		route.params.subscribe(params => this.bookmarkId = params['bookmarkId']);

		if (this.bookmarkId) {
			bookmarkService.getBookmarkById(this.bookmarkId).subscribe(
				(bookmark) => this.bookmark = bookmark,
				(error) => this.error = error
			);
		} else {
			this.bookmark = new Bookmark();
		}
	}

	submitBookmark() {
		if (this.bookmarkId) {
			this.bookmarkService.createBookmark(this.bookmark).subscribe(
				(bookmark) => this.router.navigate(['bookmarks', this.bookmarkId]),
				(error) => this.error = error
			);
		} else {
			this.bookmarkService.createBookmark(this.bookmark).subscribe(
				(bookmarks) => this.router.navigate(['bookmarks']),
				(error) => this.error = error
			);
		}
	}
}