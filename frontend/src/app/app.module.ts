import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { PostListComponent } from './post-list/post-list.component';
import { HeaderLinksComponent } from './header-links/header-links.component';
import { PostDetailsComponent } from './post-details/post-details.component';
import { BookmarkListComponent } from './bookmark-list/bookmark-list.component';
import { BookmarkDetailsComponent } from './bookmark-details/bookmark-details.component';
import { PostService } from './post-service/post.service';
import { BookmarkService } from './bookmark-service/bookmark.service';
import { PostFormComponent } from './post-form/post-form.component';
import { BookmarkFormComponent } from './bookmark-form/bookmark-form.component'; 
import { PostSortPipe } from './post-service/post-sort.pipe';
import { BookmarkSortPipe } from './bookmark-service/bookmark-sort.pipe';
import { PostCardComponent } from './post-card/post-card.component';
import { BookmarkCardComponent } from './bookmark-card/bookmark-card.component';

@NgModule({
   declarations: [
   		AppComponent,
   		HeaderComponent,
   		PostListComponent,
   		HeaderLinksComponent,
   		PostDetailsComponent,
   		BookmarkListComponent,
         PostFormComponent,
         BookmarkFormComponent,
         PostSortPipe,
         BookmarkSortPipe,
         PostCardComponent,
         BookmarkCardComponent,
         BookmarkDetailsComponent
   		],
   imports: [
   		BrowserModule,
   		RouterModule.forRoot([
		   		{
		   			path: '',
		   			redirectTo: 'posts',
		   			pathMatch: 'full'
		   		},
		   		{
		   		   path: 'posts',
		   		   component: PostListComponent
		   		},
               {
                  path:'posts/create',
                  component: PostFormComponent
               },
               {
                  path: 'posts/:postId',
                  component: PostDetailsComponent
               },
               {
                  path:'posts/:postId/update',
                  component: PostFormComponent
               },
               {
                  path: 'bookmarks',
                  component: BookmarkListComponent
               },
               {
                  path: 'bookmarks/create',
                  component: BookmarkFormComponent
               },
               {
                  path: 'bookmarks/:bookmarkId',
                  component: BookmarkDetailsComponent
               },
               {
                  path: 'bookmarks/:bookmarkId/update',
                  component: BookmarkFormComponent
               }
   			]),
         HttpClientModule,
         FormsModule
   		],
   providers: [PostService, BookmarkService],
   bootstrap: [AppComponent]
})
export class AppModule { }