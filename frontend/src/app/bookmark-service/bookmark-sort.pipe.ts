import { Bookmark } from './bookmark';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'bookmarkSort'})
export class BookmarkSortPipe implements PipeTransform {
	transform(values: Bookmark[]): Bookmark[] {
		if (values) {
			values.sort((first: Bookmark, second: Bookmark) => {
				if (first.priority >
					second.priority) {
						return -1;
				}
				if (first.priority < 
					second.priority) {
						return 1;
				}
				return 0;
			});
		}
		return values;
	}
}