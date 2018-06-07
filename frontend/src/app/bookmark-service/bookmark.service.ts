import { Injectable } from '@angular/core';
import { Bookmark } from './bookmark';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class BookmarkService {
	private http: HttpClient;
	private url: string = 'http://localhost:8080/api/v1/bookmark';
	private bookmarks: Bookmark[];

	constructor(http: HttpClient) {
		this.http = http;
	}//constructor

	getAllBookmarks(): Observable<Bookmark[]> {
    return this.http.get<Bookmark[]>(this.url);
  }

  getBookmarkById(bookmarkId: number): Observable<Bookmark> {
    return this.http.get<Bookmark>(`${this.url}/${bookmarkId}`);
  }

  createBookmark(bookmark: Bookmark): Observable<Bookmark> {
    return this.http.post<Bookmark>(`${this.url}/`, bookmark);
  }

  updateBookmark(bookmarkId: number, bookmark: Bookmark): Observable<Bookmark> {
    return this.http.put<Bookmark>(`${this.url}/${bookmarkId}`, bookmark);
  }

  deleteBookmark(bookmarkId: number): Observable<Bookmark> {
    return this.http.delete<Bookmark>(`${this.url}/${bookmarkId}`);
  }


}//class