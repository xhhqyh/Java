/*
	项目名: 图书管理系统
	数据库: Oracle
	管理工具: PLSQL
	时间: 2017/10/24
	作者: 祁燕辉
*/

-- 创建表空间:BookDB
CREATE TABLESPACE BookDB
DATAFILE 'D:\BookDB.dbf'
SIZE 200M;

/*
	一、用户模块
*/

-- 管理员信息表(manager)
create table manager(
	manid int primary key,        -- 主键
	manname varchar(30) not null, -- 管理员名称
	manpwd varchar(30) not null,  -- 管理员密码
  mantype varchar(30) not null  -- 管理员类别
)TABLESPACE BookDB;

insert into manager values(my_manager.nextval, 'Admin', 'admin', '超级管理员');
insert into manager values(my_manager.nextval, 'Admin', 'admin', '内容管理员');

create sequence my_manager
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

-- 用户等级表(userrank)
create table userrank(
	rankid int primary key,       -- 主键
	rankname varchar(20) not null --用户等级名
)TABLESPACE BookDB;

insert into userrank values(my_userrank.nextval, '普通会员');

select * from userrank;

create sequence my_userrank
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

select * from userinfo uo, userrank uk where uo.rankid = uk.rankid;

-- 用户信息表(userinfo)
create table userinfo(
	userid int primary key,  -- 主键
	username varchar(20) not null, -- 用户名
	truename varchar(20) not null, -- 用户真实的姓名
	password varchar(20) not null, -- 密码
	city varchar(100) not null, -- 地址
	sex varchar(5) not null, -- 性别
	picture varchar(50) not null, -- 用户头像
	postcode varchar(6) not null, -- 用户的邮编
	rankid int default(0), -- 用户等级,外键
	amount number(6,2), -- 消费金额
	tel varchar(11) not null, -- 电话
	email varchar(50) not null, -- 用户的Email地址
	freeze int, -- 用户是否被冻结
	foreign key(rankid) references userrank(rankid)
)TABLESPACE BookDB;

insert into userinfo values(my_userinfo.nextval, '祁艳辉', '祁艳辉'，'1234', '湖北省武汉市', '1', '/Public/dishimg/a.jpg', '162250', (select rankid from userrank where rankname = '普通会员'), 20, 18571421324, '2994010023@qq.com', 1);

select * from userinfo;

create sequence my_userinfo
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

/*
	二、图书模块
*/

-- 图书类别表(booktype)
create table booktype(
	typeid int primary key,   -- 主键
	typename varchar(50) not null -- 图书类别名
)TABLESPACE BookDB;

create sequence my_booktype
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

insert into booktype values(my_booktype.nextval, '政治');

select * from booktype;


-- 图书信息表(bookinfo)
create table bookinfo (
  bookid int primary key,
	isbn varchar(15)not null,  -- 主键
	bookname varchar(200) not null, -- 图书名
	typeid int not null, -- 外键booktype的typeid字段
	publisher varchar(100) not null, -- 出版社名称
	writer varchar(100) not null, --图书的作者
	picture varchar(50) not null, -- 图书图片
	introduce varchar2(500), -- 图书的简介 
	price number(6,2) not null, -- 定价
	newbook int not null, -- 标识是否为新书
	command int, -- 标识是否为推荐
	foreign key(typeid) references booktype(typeid)
)TABLESPACE BookDB;

insert into bookinfo values(my_bookinfo.nextval, '123', '岛上书店1', 1, '铁道出版社', '万亚辉', '/Public/dishimg/b.jpg', '哈哈,这是一本书', 20, 1, 0);
insert into bookinfo values(my_bookinfo.nextval, '123', '岛上书店2', 1, '铁道出版社', '万亚辉', '/Public/dishimg/b.jpg', '哈哈,这是一本书', 20, 1, 0);
insert into bookinfo values(my_bookinfo.nextval, '123341', '岛上书店3', 2, '铁道出版社', '万亚辉', '/Public/dishimg/c.jpg', '哈哈,这是一本书', 100, 0, 0);
insert into bookinfo values(my_bookinfo.nextval, '1234321', '岛上书店4', 3, '铁道出版社', '万亚辉', '/Public/dishimg/d.jpg', '哈哈,这是一本书', 23, 0, 0);
insert into bookinfo values(my_bookinfo.nextval, '12354', '岛上书店5', 4, '铁道出版社', '万亚辉', '/Public/dishimg/e.jpg', '哈哈,这是一本书', 20, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '12321', '岛上书店6', 1, '铁道出版社', '万亚辉', '/Public/dishimg/f.jpg', '哈哈,这是一本书', 20, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '132123', '岛上书店7', 3, '铁道出版社', '万亚辉', '/Public/dishimg/g.jpg', '哈哈,这是一本书', 20, 0, 1);
insert into bookinfo values(my_bookinfo.nextval, '14321123', '岛上书店8', 1, '铁道出版社', '万亚辉', '/Public/dishimg/h.jpg', '哈哈,这是一本书', 20, 0, 1);
insert into bookinfo values(my_bookinfo.nextval, '54123', '岛上书店9', 1, '铁道出版社', '王亚辉', '/Public/dishimg/b.jpg', '哈哈,这是一本书', 23, 0, 0);
insert into bookinfo values(my_bookinfo.nextval, '4123', '岛上书店10', 1, '铁道出版社', '陈志豪', '/Public/dishimg/c.jpg', '哈哈,这是一本书', 25, 0, 0);
insert into bookinfo values(my_bookinfo.nextval, '1523', '岛上书店11', 2, '铁道出版社', '万亚辉', '/Public/dishimg/d.jpg', '哈哈,这是一本书', 43, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '1233', '岛上书店12', 2, '铁道出版社', '陈志豪', '/Public/dishimg/e.jpg', '哈哈,这是一本书', 23, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '1213', '岛上书店13', 3, '铁道出版社', '陈志豪', '/Public/dishimg/b.jpg', '哈哈,这是一本书', 20, 1, 0);
insert into bookinfo values(my_bookinfo.nextval, '1213', '岛上书店14', 4, '铁道出版社', '万亚辉', '/Public/dishimg/f.jpg', '哈哈,这是一本书', 56, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '1253', '岛上书店15', 1, '铁道出版社', '陈志豪', '/Public/dishimg/g.jpg', '哈哈,这是一本书', 20, 0, 0);
insert into bookinfo values(my_bookinfo.nextval, '1233', '岛上书店16', 2, '铁道出版社', '陈志豪', '/Public/dishimg/d.jpg', '哈哈,这是一本书', 20, 0, 1);
insert into bookinfo values(my_bookinfo.nextval, '1233', '岛上书店17', 2, '铁道出版社', '万亚辉', '/Public/dishimg/c.jpg', '哈哈,这是一本书', 69, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '1253', '岛上书店18', 1, '铁道出版社', '陈志豪', '/Public/dishimg/d.jpg', '哈哈,这是一本书', 20, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '12143', '岛上书店19', 1, '铁道出版社', '陈志豪', '/Public/dishimg/b.jpg', '哈哈,这是一本书', 20, 0, 0);
insert into bookinfo values(my_bookinfo.nextval, '12331', '岛上书店20', 3, '铁道出版社', '高灿', '/Public/dishimg/f.jpg', '哈哈,这是一本书', 12, 1, 0);
insert into bookinfo values(my_bookinfo.nextval, '125433', '岛上书店21', 1, '铁道出版社', '万亚辉', '/Public/dishimg/g.jpg', '哈哈,这是一本书', 20, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '123', '岛上书店22', 1, '铁道出版社', '万亚辉', '/Public/dishimg/d.jpg', '哈哈,这是一本书', 20, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '123', '岛上书店23', 1, '铁道出版社', '万亚辉', '/Public/dishimg/c.jpg', '哈哈,这是一本书', 20, 1, 1);

create sequence my_bookinfo
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

select * from bookinfo;
select * from bookinfo bo, booktype be where bo.typeid = be.typeid; 


/*
	三、订单模块
*/

-- 购物车表(buycarinfo)
create table buycarinfo(
	carid int primary key, -- 主键
	userid int not null, -- 对应用户表的userid , 外键
	bookid int not null, -- 对应图书表的isbn ， 外键
	bookname varchar(50) not null,  -- 图书名
	price number(6,2) not null, -- 定价
	num int not null, -- 数量
	foreign key(userid) references userinfo(userid),
	foreign key(bookid) references bookinfo(bookid)
)TABLESPACE BookDB;

SELECT * from buycarinfo;

delete from buycarinfo where userid = 1 and bookname = '岛上书店2'

select a.*, rownum from (select bookname, price, count(bookname) num from (select b.* from buycarinfo b where userid = (
				select userid from userinfo where username = '齐艳辉')) m group by bookname,price ) a 
				where rownum between 1 and 7
        
select * from buycarinfo  where userid = (
				select userid from userinfo where username = '齐艳辉')
        
select a.*, rownum from (select * from buycarinfo  where userid = (select userid from userinfo where username = '齐艳辉')) a where rownum between 1 and 7;

create sequence my_buycarinfo
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

-- 订单信息表(orderinfo)
create table orderinfo(
	orderid int primary key,   -- 主键
	username varchar(20) not null,  -- 用户名
	truename varchar(20) not null, --真实名
	address varchar(100) not null, -- 地址
	postcode varchar(6) not null,  -- 邮编
	tel number(11) not null,       -- 电话
	email varchar(50) not null,    -- email地址
	orderdate date default sysdate, -- 订单日期
	enfore int -- 订单是否被处理
)TABLESPACE BookDB;

create sequence my_orderinfo
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

select oo.*,rownum rn from orderinfo oo, orderDetail ol where oo.orderid = ol.orderid;

select oo.*,ol.*,rownum rn from orderinfo oo, orderDetail ol where oo.orderid = ol.orderid;
select * from (select t.*, rownum rn from bookinfo t order by bookid) m, booktype b where m.typeid=b.typeid;
select * from (select t.*, rownum rn from bookinfo t order by bookid) m, booktype b where m.typeid=b.typeid and m.rn between 20 and 25

select * from orderinfo;
select * from orderDetail;

select o.*,rownum rn from orderinfo o where username = '齐艳辉';
select orderid, sum(price*num) from orderDetail group by orderid ;

select * from  (select o.*,rownum rn from orderinfo o ) a, (select orderid, sum(price*num) col from orderDetail group by orderid) b where a.orderid = b.orderid and a.rn between 1 and 5;


select max(orderid) a from orderinfo 

-- 订单信息明细表(orderDetail)
create table orderDetail(
	detid int primary key,   -- 主键
	orderid int not null,  -- 订单号, 外键, 引用orderinfo(orderid)
  bookid int not null,  -- 图书的bookid,外键
	price number(6, 2) not null,  -- 图书单价
	num int not null, -- 购买的图书数量
	foreign key(orderid) references orderinfo(orderid),
  foreign key(bookid) references bookinfo(bookid)
)TABLESPACE BookDB;

select * from orderDetail;

select bookid, sum(num) col from orderDetail group by bookid order by col desc ;
select a.*, rownum rn from (select bookid, sum(num) col from orderDetail group by bookid order by col desc ) a ;

select * from (
       select a.*, rownum rn from (select bookid, sum(num) col from orderDetail group by bookid order by col desc ) a
) b where b.rn between 1 and 5;

create sequence my_orderDetail
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

/*
	四、工具表
*/

-- 公告信息表(bbs)
create table bbs(
	bbsid int primary key, -- 主键
  bbshead varchar(100) not null, -- 公告标题
	bbstext varchar(1000) not null, -- 公告内容
	intime date default sysdate -- 公告时间
)TABLESPACE BookDB;

create sequence my_bbs
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

insert into bbs(bbsid, bbshead, bbstext) values(my_bbs.nextval, ?, ?)

select * from bbs;

-- 投票信息表(poll)
create table poll(
	pollid int primary key, -- 主键
	pollname varchar(50) not null, -- 投票的名字
	pollnum number(6) -- 数量
)TABLESPACE BookDB;

insert into poll values(my_poll.nextval, '经济', 20);
insert into poll values(my_poll.nextval, '经济', 20);
insert into poll values(my_poll.nextval, '网络', 20);
insert into poll values(my_poll.nextval, '政治', 20);
insert into poll values(my_poll.nextval, '文化', 200);

select * from poll;

create sequence my_poll
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

select pollname,sum(pollnum) col from poll group by pollname;