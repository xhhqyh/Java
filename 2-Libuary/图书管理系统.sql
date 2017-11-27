/*
	��Ŀ��: ͼ�����ϵͳ
	���ݿ�: Oracle
	������: PLSQL
	ʱ��: 2017/10/24
	����: �����
*/

-- ������ռ�:BookDB
CREATE TABLESPACE BookDB
DATAFILE 'D:\BookDB.dbf'
SIZE 200M;

/*
	һ���û�ģ��
*/

-- ����Ա��Ϣ��(manager)
create table manager(
	manid int primary key,        -- ����
	manname varchar(30) not null, -- ����Ա����
	manpwd varchar(30) not null,  -- ����Ա����
  mantype varchar(30) not null  -- ����Ա���
)TABLESPACE BookDB;

insert into manager values(my_manager.nextval, 'Admin', 'admin', '��������Ա');
insert into manager values(my_manager.nextval, 'Admin', 'admin', '���ݹ���Ա');

create sequence my_manager
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

-- �û��ȼ���(userrank)
create table userrank(
	rankid int primary key,       -- ����
	rankname varchar(20) not null --�û��ȼ���
)TABLESPACE BookDB;

insert into userrank values(my_userrank.nextval, '��ͨ��Ա');

select * from userrank;

create sequence my_userrank
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

select * from userinfo uo, userrank uk where uo.rankid = uk.rankid;

-- �û���Ϣ��(userinfo)
create table userinfo(
	userid int primary key,  -- ����
	username varchar(20) not null, -- �û���
	truename varchar(20) not null, -- �û���ʵ������
	password varchar(20) not null, -- ����
	city varchar(100) not null, -- ��ַ
	sex varchar(5) not null, -- �Ա�
	picture varchar(50) not null, -- �û�ͷ��
	postcode varchar(6) not null, -- �û����ʱ�
	rankid int default(0), -- �û��ȼ�,���
	amount number(6,2), -- ���ѽ��
	tel varchar(11) not null, -- �绰
	email varchar(50) not null, -- �û���Email��ַ
	freeze int, -- �û��Ƿ񱻶���
	foreign key(rankid) references userrank(rankid)
)TABLESPACE BookDB;

insert into userinfo values(my_userinfo.nextval, '���޻�', '���޻�'��'1234', '����ʡ�人��', '1', '/Public/dishimg/a.jpg', '162250', (select rankid from userrank where rankname = '��ͨ��Ա'), 20, 18571421324, '2994010023@qq.com', 1);

select * from userinfo;

create sequence my_userinfo
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

/*
	����ͼ��ģ��
*/

-- ͼ������(booktype)
create table booktype(
	typeid int primary key,   -- ����
	typename varchar(50) not null -- ͼ�������
)TABLESPACE BookDB;

create sequence my_booktype
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

insert into booktype values(my_booktype.nextval, '����');

select * from booktype;


-- ͼ����Ϣ��(bookinfo)
create table bookinfo (
  bookid int primary key,
	isbn varchar(15)not null,  -- ����
	bookname varchar(200) not null, -- ͼ����
	typeid int not null, -- ���booktype��typeid�ֶ�
	publisher varchar(100) not null, -- ����������
	writer varchar(100) not null, --ͼ�������
	picture varchar(50) not null, -- ͼ��ͼƬ
	introduce varchar2(500), -- ͼ��ļ�� 
	price number(6,2) not null, -- ����
	newbook int not null, -- ��ʶ�Ƿ�Ϊ����
	command int, -- ��ʶ�Ƿ�Ϊ�Ƽ�
	foreign key(typeid) references booktype(typeid)
)TABLESPACE BookDB;

insert into bookinfo values(my_bookinfo.nextval, '123', '�������1', 1, '����������', '���ǻ�', '/Public/dishimg/b.jpg', '����,����һ����', 20, 1, 0);
insert into bookinfo values(my_bookinfo.nextval, '123', '�������2', 1, '����������', '���ǻ�', '/Public/dishimg/b.jpg', '����,����һ����', 20, 1, 0);
insert into bookinfo values(my_bookinfo.nextval, '123341', '�������3', 2, '����������', '���ǻ�', '/Public/dishimg/c.jpg', '����,����һ����', 100, 0, 0);
insert into bookinfo values(my_bookinfo.nextval, '1234321', '�������4', 3, '����������', '���ǻ�', '/Public/dishimg/d.jpg', '����,����һ����', 23, 0, 0);
insert into bookinfo values(my_bookinfo.nextval, '12354', '�������5', 4, '����������', '���ǻ�', '/Public/dishimg/e.jpg', '����,����һ����', 20, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '12321', '�������6', 1, '����������', '���ǻ�', '/Public/dishimg/f.jpg', '����,����һ����', 20, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '132123', '�������7', 3, '����������', '���ǻ�', '/Public/dishimg/g.jpg', '����,����һ����', 20, 0, 1);
insert into bookinfo values(my_bookinfo.nextval, '14321123', '�������8', 1, '����������', '���ǻ�', '/Public/dishimg/h.jpg', '����,����һ����', 20, 0, 1);
insert into bookinfo values(my_bookinfo.nextval, '54123', '�������9', 1, '����������', '���ǻ�', '/Public/dishimg/b.jpg', '����,����һ����', 23, 0, 0);
insert into bookinfo values(my_bookinfo.nextval, '4123', '�������10', 1, '����������', '��־��', '/Public/dishimg/c.jpg', '����,����һ����', 25, 0, 0);
insert into bookinfo values(my_bookinfo.nextval, '1523', '�������11', 2, '����������', '���ǻ�', '/Public/dishimg/d.jpg', '����,����һ����', 43, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '1233', '�������12', 2, '����������', '��־��', '/Public/dishimg/e.jpg', '����,����һ����', 23, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '1213', '�������13', 3, '����������', '��־��', '/Public/dishimg/b.jpg', '����,����һ����', 20, 1, 0);
insert into bookinfo values(my_bookinfo.nextval, '1213', '�������14', 4, '����������', '���ǻ�', '/Public/dishimg/f.jpg', '����,����һ����', 56, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '1253', '�������15', 1, '����������', '��־��', '/Public/dishimg/g.jpg', '����,����һ����', 20, 0, 0);
insert into bookinfo values(my_bookinfo.nextval, '1233', '�������16', 2, '����������', '��־��', '/Public/dishimg/d.jpg', '����,����һ����', 20, 0, 1);
insert into bookinfo values(my_bookinfo.nextval, '1233', '�������17', 2, '����������', '���ǻ�', '/Public/dishimg/c.jpg', '����,����һ����', 69, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '1253', '�������18', 1, '����������', '��־��', '/Public/dishimg/d.jpg', '����,����һ����', 20, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '12143', '�������19', 1, '����������', '��־��', '/Public/dishimg/b.jpg', '����,����һ����', 20, 0, 0);
insert into bookinfo values(my_bookinfo.nextval, '12331', '�������20', 3, '����������', '�߲�', '/Public/dishimg/f.jpg', '����,����һ����', 12, 1, 0);
insert into bookinfo values(my_bookinfo.nextval, '125433', '�������21', 1, '����������', '���ǻ�', '/Public/dishimg/g.jpg', '����,����һ����', 20, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '123', '�������22', 1, '����������', '���ǻ�', '/Public/dishimg/d.jpg', '����,����һ����', 20, 1, 1);
insert into bookinfo values(my_bookinfo.nextval, '123', '�������23', 1, '����������', '���ǻ�', '/Public/dishimg/c.jpg', '����,����һ����', 20, 1, 1);

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
	��������ģ��
*/

-- ���ﳵ��(buycarinfo)
create table buycarinfo(
	carid int primary key, -- ����
	userid int not null, -- ��Ӧ�û����userid , ���
	bookid int not null, -- ��Ӧͼ����isbn �� ���
	bookname varchar(50) not null,  -- ͼ����
	price number(6,2) not null, -- ����
	num int not null, -- ����
	foreign key(userid) references userinfo(userid),
	foreign key(bookid) references bookinfo(bookid)
)TABLESPACE BookDB;

SELECT * from buycarinfo;

delete from buycarinfo where userid = 1 and bookname = '�������2'

select a.*, rownum from (select bookname, price, count(bookname) num from (select b.* from buycarinfo b where userid = (
				select userid from userinfo where username = '���޻�')) m group by bookname,price ) a 
				where rownum between 1 and 7
        
select * from buycarinfo  where userid = (
				select userid from userinfo where username = '���޻�')
        
select a.*, rownum from (select * from buycarinfo  where userid = (select userid from userinfo where username = '���޻�')) a where rownum between 1 and 7;

create sequence my_buycarinfo
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

-- ������Ϣ��(orderinfo)
create table orderinfo(
	orderid int primary key,   -- ����
	username varchar(20) not null,  -- �û���
	truename varchar(20) not null, --��ʵ��
	address varchar(100) not null, -- ��ַ
	postcode varchar(6) not null,  -- �ʱ�
	tel number(11) not null,       -- �绰
	email varchar(50) not null,    -- email��ַ
	orderdate date default sysdate, -- ��������
	enfore int -- �����Ƿ񱻴���
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

select o.*,rownum rn from orderinfo o where username = '���޻�';
select orderid, sum(price*num) from orderDetail group by orderid ;

select * from  (select o.*,rownum rn from orderinfo o ) a, (select orderid, sum(price*num) col from orderDetail group by orderid) b where a.orderid = b.orderid and a.rn between 1 and 5;


select max(orderid) a from orderinfo 

-- ������Ϣ��ϸ��(orderDetail)
create table orderDetail(
	detid int primary key,   -- ����
	orderid int not null,  -- ������, ���, ����orderinfo(orderid)
  bookid int not null,  -- ͼ���bookid,���
	price number(6, 2) not null,  -- ͼ�鵥��
	num int not null, -- �����ͼ������
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
	�ġ����߱�
*/

-- ������Ϣ��(bbs)
create table bbs(
	bbsid int primary key, -- ����
  bbshead varchar(100) not null, -- �������
	bbstext varchar(1000) not null, -- ��������
	intime date default sysdate -- ����ʱ��
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

-- ͶƱ��Ϣ��(poll)
create table poll(
	pollid int primary key, -- ����
	pollname varchar(50) not null, -- ͶƱ������
	pollnum number(6) -- ����
)TABLESPACE BookDB;

insert into poll values(my_poll.nextval, '����', 20);
insert into poll values(my_poll.nextval, '����', 20);
insert into poll values(my_poll.nextval, '����', 20);
insert into poll values(my_poll.nextval, '����', 20);
insert into poll values(my_poll.nextval, '�Ļ�', 200);

select * from poll;

create sequence my_poll
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocache
nocycle

select pollname,sum(pollnum) col from poll group by pollname;