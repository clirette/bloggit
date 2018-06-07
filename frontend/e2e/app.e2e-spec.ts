import { browser, element, by } from 'protractor';

describe('Bloggit App Landing Page', function() {

	it('should have a header with the site name', function() {
    	browser.get('/');
        expect(element(by.css('.title')).getText()).toContain("Bloggit");   
   	});

	it('should have a initial body of the Post List', function() {
       browser.get('/');
       expect(element(by.tagName('h2')).getText()).toContain("Posts");
   	});

   	it('should contain a list of Post Cards', function() {
   	       browser.get('/');
   	       let cardListWrapper = element(by.tagName('post-list'));
   	       let cards = cardListWrapper.all(by.tagName('post-card'));
   	       expect(cardListWrapper).toBeDefined();
   	       expect(cards.count()).toBe(4);
   	       cards.each(function(card) {
   	           expect(card.element(by.css('.glyphicon-remove'))).toBeDefined();
   	       });
   	});

   	it(`should have a button to
       navigate to the Create Post page.`, function() {
       browser.get('/');
       var createButton = element(
           by.cssContainingText('.btn', 'Create Post'));
       createButton.click();
       var headline = element(by.tagName('post-form'))
           .element(by.tagName('h1'));
       expect(headline.getText()).toContain("Create A New Post");
   });

   	it('should create a new post', function() {
   	       browser.get('/');
   	       element(
   	           by.cssContainingText('.btn', 'Create Post'))
   	           .click();
   	       element(by.name('title')).sendKeys("My Title");
   	       element(by.name('body')).sendKeys("My Body");
   	       element(by.name('author')).sendKeys("Me");
   	       element(by.cssContainingText('.btn', 'Submit')).click();
   	       expect(element(by.tagName('h2')).getText())
   	           .toContain("Posts");
   	       var newCard = element(
   	           by.cssContainingText('post-card', "MY TITLE"));
   	       expect(newCard).toBeDefined();
   	       expect(newCard.element(by.className('panel-heading')).getText())
   	           .toContain("MY TITLE");
   	       expect(newCard.element(by.className('panel-body')).getText())
   	           .toContain("My Body");
   	 });

});