import { Component } from '@angular/core';
import 'rxjs/add/operator/filter';
import {
   Router,
   RouterEvent,
   NavigationStart
} from '@angular/router';

@Component({
   selector: 'header-links',
   templateUrl: './header-links.component.html',
   styleUrls: ['./header-links.component.css']
})
export class HeaderLinksComponent {

	private router: Router;
	private currentRoute: string;

	constructor(router: Router) {
	    this.router = router;
	    this.router.events
	       .filter(event => event instanceof NavigationStart)
	       .subscribe((event: RouterEvent) => this.setCurrentRoute(event.url));
	}

	private goToRoute(url: string): void {
	    this.router.navigate([url]);
	}

	private setCurrentRoute(url: string): void {
	    if (url.indexOf('posts') > -1) {
	        this.currentRoute = 'posts';
	    } else if (url.indexOf('bookmarks') > -1) {
	        this.currentRoute = 'bookmarks';
	    } else {
	        this.currentRoute = 'posts';
	    }
	}
}