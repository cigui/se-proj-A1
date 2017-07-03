/* 通过完整一次业务流程检查数据库设计是否正确 */
insert into books(ISBN, Title, Author, Publisher) values(9784048928625, '东方文果真报', 'ZUN', '株式会社KADOKAWA');
insert into categories(`Name`) values('东方project'); 
insert into bookcaterelationship values(9784048928625, 1); /* 建立书与种类的联系 */
insert into Locations(province, city, district) values('上海', '上海', '闵行'); /* 地址1 */
insert into Locations(province, city, district) values('上海', '上海', '徐汇'); /* 地址2 */
insert into users(L_ID, Nickname, `password`, email, role, points, credit) values(1, 'nn', 'pwd', 'em', 0, 10, 0); /* 用户1 */
insert into users(L_ID, Nickname, `password`, email, role, points, credit) values(2, 'nnn', 'pwd', 'emm', 0, 10, 0); /* 用户2 */
insert into bookcomments(ID, ISBN, Discription, Score) values(1, 9784048928625, '这实在太棒了', 10); /* 图书评价 */
insert into bookreleases(ID, ISBN, Publish_date, Discription, `Status`, Price) values(1, 9784048928625, '2017:3:30', '全新', 0, 10); /* 上传图书信息 */
insert into borrowitems values(1, 2); /* 加入借书车 */

/* 确定借书 */
delete from borrowitems where R_ID = 1 and ID = 2; 
insert into borrowhistory(OrderStatus, Location, ID, R_ID) values(0, '上海交通大学徐汇校区', 2, 1);
update bookReleases set `Status` = 1 where R_ID = 1;
update users set points = points-10 where ID = 2;

/* 图书确认送达，未评价 */
update borrowhistory set OrderStatus = 1 where H_ID = 1;

/* 借阅评价 */
insert into borrowcomments(H_ID, BorrowComment, Score) values(1, '符合描述', 10);
update borrowhistory set OrderStatus = 2 where H_ID = 1;
update users set credit = credit+10 where ID = 1;