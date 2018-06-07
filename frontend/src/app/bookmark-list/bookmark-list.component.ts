import { Component } from '@angular/core';
import { BookmarkService } from '../bookmark-service/bookmark.service';
import { Bookmark } from '../bookmark-service/bookmark';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
   selector: 'bookmark-list',
   templateUrl: 'bookmark-list.component.html',
   styleUrls: ['bookmark-list.component.css']
})
export class BookmarkListComponent {
	private bookmarks: Bookmark[];
	private error: HttpErrorResponse;
  private bookmarkService: BookmarkService;

	constructor(bookmarkService: BookmarkService) {
      this.bookmarkService = bookmarkService;
       bookmarkService.getAllBookmarks().subscribe(
       	bookmarks => this.bookmarks = bookmarks,
       	error => this.error = error
       );
   }

   handleBookmarkDeleted(bookmark: Bookmark) {
     this.bookmarkService.deleteBookmark(bookmark.bookmarkId).subscribe(
       (bookmark) => this.deleteBookmarkFromList(bookmark.bookmarkId),
       (error) => this.error = error
     );
   }

   deleteBookmarkFromList(bookmarkId: number) {
     const index: number = this.bookmarks.findIndex(
       (bookmark) => bookmark.bookmarkId === bookmarkId);
     this.bookmarks.splice(index, 1);
   }
}