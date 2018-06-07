create table posts (
  post_id       bigserial primary key,
  title         text not null,
  body          text,
  author        text not null,
  last_updated  datetime
)