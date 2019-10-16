-- we don't know how to generate root <with-no-name> (class Root) :(
create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

create table usr
(
  id bigserial not null
    constraint usr_pkey
      primary key,
  login varchar(255) not null,
  username varchar(255) not null,
  email varchar(255),
  password varchar(255) not null
);

alter table usr owner to postgres;

create table country
(
  id serial not null
    constraint country_pkey
      primary key,
  name varchar(255) not null
);

alter table country owner to postgres;

create table hotel
(
  id bigserial not null
    constraint hotel_pk
      primary key,
  name varchar(255) not null,
  stars integer not null,
  website varchar(255) not null,
  latitude varchar(255),
  longitude varchar(255),
  features varchar(2048)
);

alter table hotel owner to postgres;

create table tour
(
  id bigserial not null
    constraint tour_pkey
      primary key,
  photo varchar(255),
  data timestamp,
  duration integer,
  description varchar(2048),
  cost integer,
  tour_type varchar(255),
  hotel_id bigint not null
    constraint tour_hotel_fk
      references hotel,
  country_id bigint not null
    constraint tour_country_fk
      references country
);

alter table tour owner to postgres;

create table user_tour
(
  user_id bigint not null
    constraint user_tour_user_id_fkey
      references usr,
  tour_id bigint not null
    constraint user_tour_tour_id_fkey
      references tour,
  constraint user_tour_pkey
    primary key (user_id, tour_id)
);

alter table user_tour owner to postgres;

create table review
(
  id bigserial not null
    constraint review_pkey
      primary key,
  tourDate timestamp,
  text varchar(2048),
  user_id bigint not null
    constraint review_user_id_fkey
      references usr,
  tour_id bigint not null
    constraint review_tour_id_fkey
      references tour
);

alter table review owner to postgres;



