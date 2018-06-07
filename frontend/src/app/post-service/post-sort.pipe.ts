import { Post } from './post';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'postSort', pure: false})
export class PostSortPipe implements PipeTransform {
     transform(values: Post[], order?: string): Post[] {
        if (values) {
            values.sort((first: Post, second: Post) => {
                if (first.title.toLowerCase() <
                    second.title.toLowerCase()) {
                    return order === 'asc' ? 1 : -1;
                }
                if (first.title.toLowerCase() >
                    second.title.toLowerCase()) {
                    return order === 'asc' ? -1 : 1;
                }
                return 0;
            });
        }
        return values;
    }
}