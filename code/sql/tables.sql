/*==============================================================*/
/* DBMS name:      MySQL 5.7                                    */
/* Modified on:     2017/7/2                                    */
/*==============================================================*/


drop table if exists BookCateRelationship;

drop table if exists BookComments;

drop table if exists BorrowComments;

drop table if exists BorrowingItems;

drop table if exists BorrowingHistory;

drop table if exists BookReleases;

drop table if exists Books;

drop table if exists Categories;

drop table if exists Users;

drop table if exists Location;

/*==============================================================*/
/* Table: BookCateRelationship                                  */
/*==============================================================*/
create table BookCateRelationship
(
   isbn                 bigint not null,
   cate_id              int not null,
   primary key (isbn, cate_id)
);

/*==============================================================*/
/* Table: BookComments                                          */
/*==============================================================*/
create table BookComments
(
   id                   int not null,
   isbn                 bigint not null,
   discription          varchar(140) not null,
   score                int not null,
   primary key (id, isbn)
);

/*==============================================================*/
/* Table: BookReleases                                          */
/*==============================================================*/
create table BookReleases
(
   r_id                 int not null auto_increment,
   id                   int not null,
   isbn                 bigint not null,
   publish_date         date not null,
   discription          varchar(140),
   status               smallint not null,
   price                int not null,
   primary key (r_id)
);

/*==============================================================*/
/* Table: Books                                                 */
/*==============================================================*/
create table Books
(
   isbn                 bigint not null,
   title                varchar(40) not null,
   author               varchar(40) not null,
   publisher            varchar(40) not null,
   translator           varchar(40),
   primary key (isbn)
);

/*==============================================================*/
/* Table: BorrowComments                                        */
/*==============================================================*/
create table BorrowComments
(
   h_id                 int not null,
   borrowComment        varchar(140),
   score                int,
   primary key (h_id)
);

/*==============================================================*/
/* Table: BorrowingHistory                                      */
/*==============================================================*/
create table BorrowHistory
(
   orderStatus          smallint not null,
   location             varchar(50),
   date                 datetime not null DEFAULT CURRENT_TIMESTAMP,
   h_id                 int not null auto_increment,
   id                   int,
   r_id                 int,
   primary key (h_id)
);

/*==============================================================*/
/* Table: BorrowingItems                                        */
/*==============================================================*/
create table BorrowItems
(
   r_id                 int not null,
   id                   int not null,
   primary key (r_id, id)
);

/*==============================================================*/
/* Table: Categories                                            */
/*==============================================================*/
create table Categories
(
   cate_id              int not null auto_increment,
   name                 varchar(20),
   primary key (cate_id)
);

/*==============================================================*/
/* Table: Location                                              */
/*==============================================================*/
create table Locations
(
   l_id                 int not null auto_increment,
   province             varchar(20) not null,
   city                 varchar(20) not null,
   district             varchar(20) not null,
   primary key (l_id)
);

/*==============================================================*/
/* Table: Users                                                 */
/*==============================================================*/
create table Users
(
   id                   int not null auto_increment,
   l_id                 int,
   nickname             varchar(14) not null,
   password             varchar(20) not null,
   email                varchar(50) not null,
   role                 smallint not null,
   points               int not null,
   credit               int not null,
   fav_category         int,
   gender               tinyint,
   primary key (id)
);

alter table BookCateRelationship add constraint FK_Relationship_1 foreign key (isbn)
      references Books (isbn) on delete restrict on update restrict;

alter table BookCateRelationship add constraint FK_Relationship_2 foreign key (cate_id)
      references Categories (cate_id) on delete restrict on update restrict;

alter table BookComments add constraint FK_Relationship_5 foreign key (isbn)
      references Books (isbn) on delete restrict on update restrict;

alter table BookComments add constraint FK_Relationship_6 foreign key (id)
      references Users (id) on delete restrict on update restrict;

alter table BookReleases add constraint FK_Relationship_3 foreign key (isbn)
      references Books (isbn) on delete restrict on update restrict;

alter table BookReleases add constraint FK_Relationship_4 foreign key (id)
      references Users (id) on delete restrict on update restrict;

alter table BorrowComments add constraint FK_Relationship_13 foreign key (h_id)
      references BorrowingHistory (h_id) on delete restrict on update restrict;

alter table BorrowHistory add constraint FK_Relationship_10 foreign key (r_id)
      references BookReleases (r_id) on delete restrict on update restrict;

alter table BorrowHistory add constraint FK_Relationship_8 foreign key (id)
      references Users (id) on delete restrict on update restrict;

alter table BorrowItems add constraint FK_Relationship_7 foreign key (id)
      references Users (id) on delete restrict on update restrict;

alter table BorrowItems add constraint FK_Relationship_9 foreign key (r_id)
      references BookReleases (r_id) on delete restrict on update restrict;

alter table Users add constraint FK_Relationship_14 foreign key (l_id)
      references Location (l_id) on delete restrict on update restrict;

