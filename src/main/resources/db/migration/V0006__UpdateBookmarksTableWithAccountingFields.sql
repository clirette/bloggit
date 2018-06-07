alter table bookmarks add column created_on datetime;
alter table bookmarks add column created_by text;
alter table bookmarks add column last_updated datetime default NOW();