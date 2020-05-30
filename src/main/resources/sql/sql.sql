create database furnitureDB;

use furnitureDB;

create table furniture_type
(
    id       int         not null auto_increment primary key,
    name     varchar(35) not null unique,
    removed  boolean
);

create table country
(
    id       int         not null auto_increment primary key,
    name     varchar(35) not null unique,
    removed  boolean
);


create table material
(
    id       int          not null auto_increment primary key,
    name     varchar(35)  not null unique,
    description	 varchar(350) not null,
    removed  boolean
);


create table furniture
(
    id       int         not null auto_increment primary key,
    name     varchar(35) not null unique,
    price 	 int 		not null,
    create_year datetime not null default current_timestamp,
    size_info varchar(200) not null,
    guarantee bool not null,
    color varchar(200) not null,
    create_country_id int not null,
    foreign key (create_country_id) references country(id),
    furniture_type_id int not null,
    foreign key (furniture_type_id) references furniture_type(id),
    material_id int not null,
    foreign key (material_id) references material(id)
);