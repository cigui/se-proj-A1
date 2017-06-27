/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/27 17:28:05                           */
/*==============================================================*/


drop table if exists BookComments;

drop table if exists BookReleases;

drop table if exists Books;

drop table if exists BorrowComments;

drop table if exists BorrowingHistory;

drop table if exists BorrowingItems;

drop table if exists Categories;

drop table if exists Location;

drop table if exists Relationship_1;

drop table if exists Users;

/*==============================================================*/
/* Table: BookComments                                          */
/*==============================================================*/
create table BookComments
(
   ID                   int not null,
   ISBN                 bigint not null,
   Discription          varchar(140) not null,
   Score                int not null,
   primary key (ID, ISBN)
);

/*==============================================================*/
/* Table: BookReleases                                          */
/*==============================================================*/
create table BookReleases
(
   R_ID                 int not null,
   ID                   int not null,
   ISBN                 bigint not null,
   H_ID                 int,
   Publish_date         date not null,
   Discription          varchar(140),
   Status               smallint not null,
   Price                int not null,
   primary key (R_ID)
);

/*==============================================================*/
/* Table: Books                                                 */
/*==============================================================*/
create table Books
(
   ISBN                 bigint not null,
   Title                varchar(40) not null,
   Author               varchar(40) not null,
   Publisher            varchar(40) not null,
   Translator           varchar(40),
   primary key (ISBN)
);

/*==============================================================*/
/* Table: BorrowComments                                        */
/*==============================================================*/
create table BorrowComments
(
   H_ID                 int not null,
   BorrowComment        varchar(140),
   Score                int,
   primary key (H_ID)
);

/*==============================================================*/
/* Table: BorrowingHistory                                      */
/*==============================================================*/
create table BorrowingHistory
(
   OrderStatus          smallint not null,
   Location             varchar(50),
   Date                 date not null,
   H_ID                 int not null,
   ID                   int,
   R_ID                 int,
   primary key (H_ID)
);

/*==============================================================*/
/* Table: BorrowingItems                                        */
/*==============================================================*/
create table BorrowingItems
(
   R_ID                 int not null,
   ID                   int not null,
   primary key (R_ID, ID)
);

/*==============================================================*/
/* Table: Categories                                            */
/*==============================================================*/
create table Categories
(
   Cate_id              int not null,
   Name                 varchar(20),
   primary key (Cate_id)
);

/*==============================================================*/
/* Table: Location                                              */
/*==============================================================*/
create table Location
(
   L_ID                 int not null,
   Province             varchar(20) not null,
   City                 varchar(20) not null,
   District             varchar(20) not null,
   primary key (L_ID)
);

/*==============================================================*/
/* Table: Relationship_1                                        */
/*==============================================================*/
create table Relationship_1
(
   ISBN                 bigint not null,
   Cate_id              int not null,
   primary key (ISBN, Cate_id)
);

/*==============================================================*/
/* Table: Users                                                 */
/*==============================================================*/
create table Users
(
   ID                   int not null,
   L_ID                 int,
   Nickname             varchar(14) not null,
   Password             varchar(30) not null,
   Email                varchar(50) not null,
   Role                 smallint not null,
   Points               int not null,
   Credit               int not null,
   Fav_category         int,
   primary key (ID)
);

alter table BookComments add constraint FK_Relationship_5 foreign key (ISBN)
      references Books (ISBN) on delete restrict on update restrict;

alter table BookComments add constraint FK_Relationship_6 foreign key (ID)
      references Users (ID) on delete restrict on update restrict;

alter table BookReleases add constraint FK_Relationship_11 foreign key (H_ID)
      references BorrowingHistory (H_ID) on delete restrict on update restrict;

alter table BookReleases add constraint FK_Relationship_3 foreign key (ISBN)
      references Books (ISBN) on delete restrict on update restrict;

alter table BookReleases add constraint FK_Relationship_4 foreign key (ID)
      references Users (ID) on delete restrict on update restrict;

alter table BorrowComments add constraint FK_Relationship_13 foreign key (H_ID)
      references BorrowingHistory (H_ID) on delete restrict on update restrict;

alter table BorrowingHistory add constraint FK_Relationship_10 foreign key (R_ID)
      references BookReleases (R_ID) on delete restrict on update restrict;

alter table BorrowingHistory add constraint FK_Relationship_8 foreign key (ID)
      references Users (ID) on delete restrict on update restrict;

alter table BorrowingItems add constraint FK_Relationship_7 foreign key (ID)
      references Users (ID) on delete restrict on update restrict;

alter table BorrowingItems add constraint FK_Relationship_9 foreign key (R_ID)
      references BookReleases (R_ID) on delete restrict on update restrict;

alter table Relationship_1 add constraint FK_Relationship_1 foreign key (ISBN)
      references Books (ISBN) on delete restrict on update restrict;

alter table Relationship_1 add constraint FK_Relationship_2 foreign key (Cate_id)
      references Categories (Cate_id) on delete restrict on update restrict;

alter table Users add constraint FK_Relationship_14 foreign key (L_ID)
      references Location (L_ID) on delete restrict on update restrict;

