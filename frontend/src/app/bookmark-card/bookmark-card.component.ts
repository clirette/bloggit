import { 
		Component, 
		Input,
		Output,
		EventEmitter
} from '@angular/core';
import { Bookmark } from '../bookmark-service/bookmark';
import { BookmarkService } from '../bookmark-service/bookmark.service';
import { Router } from '@angular/router';

@Component({
	selector: 'bookmark-card',
	templateUrl: 'bookmark-card.component.html',
	styleUrls: ['bookmark-card.component.css']
})
export class BookmarkCardComponent {

	private router: Router;
	private bookmarkService: BookmarkService;

	@Input()
	private bookmark: Bookmark;

	@Output()
	private bookmarkDeleted: EventEmitter<Bookmark>;

	constructor() {
		this.bookmarkDeleted = new EventEmitter<Bookmark>();
	}

	updateTitle() {
		this.bookmark.title += new Date();
	}

	deleteBookmark() {
		this.bookmarkDeleted.emit(this.bookmark);
	}

}