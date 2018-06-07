create table bookmarks(
  bookmark_id   bigserial primary key,
  title         text not null,
  url           text not null,
  visible    boolean not null,
  priority      int
)