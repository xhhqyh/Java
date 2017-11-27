-- 1、管理员信息表
create table Admin_Info(
    Adm_Id int primary key,                --用户ID、主键  
    Adm_Name varchar2(10) not null,        --用户名
    Adm_Psw varchar2(20) not null,         --密码
    Adm_Remark varchar2(50)                --备注信息
)

select * from Admin_Info;

insert into Admin_Info values(1, 'Admin', '123456', '这是超级管理员的帐号信息，拥有最高权限');

select * from Admin_Info where Adm_Name = 'Admin' and Adm_Psw ='123456';


-- 2、会员信息表
create table Member_Info(
  	Mem_Id int primary key,                --会员Id (主键)
    Mem_Name varchar2(20) not null unique, --用户名
    Mem_Psw varchar2(20) not null,         --密码
    Mem_Trname varchar2(20) not null,      --真实姓名
    Mem_Sex int default('1') check(Mem_Sex in ('1','0')),   --性别
    Mem_Birthday date,                     --生日
    Mem_Address varchar2(50),              --家庭住址
    Mem_Tel int,                           --电话号码
    Mem_Email varchar2(20)                 --电子邮箱
)

insert into Member_Info values(sequence1.nextval,'极限挑战','1438','张艺兴',1,to_date('1991-10-07','yyyy-MM-dd'),'老九门',1388886666,'14725836@qq.com');
insert into Member_Info values(sequence1.nextval,'极限挑','1438','张艺兴',1,to_date('1991-10-07','yyyy-MM-dd'),'老九门',1388886666,'14725836@qq.com');
insert into Member_Info values(sequence1.nextval,'极限战','1438','张艺兴',1,to_date('1991-10-07','yyyy-MM-dd'),'老九门',1388886666,'14725836@qq.com');
insert into Member_Info values(sequence1.nextval,'极挑战','1438','张艺兴',1,to_date('1991-10-07','yyyy-MM-dd'),'老九门',1388886666,'14725836@qq.com');
insert into Member_Info values(sequence1.nextval,'限挑战','1438','张艺兴',1,to_date('1991-10-07','yyyy-MM-dd'),'老九门',1388886666,'14725836@qq.com');
insert into Member_Info values(sequence1.nextval,'d极限挑战','1438','张艺兴',1,to_date('1991-10-07','yyyy-MM-dd'),'老九门',1388886666,'14725836@qq.com');
insert into Member_Info values(sequence1.nextval,'fg极限挑战','1438','张艺兴',1,to_date('1991-10-07','yyyy-MM-dd'),'老九门',1388886666,'14725836@qq.com');
select * from Member_Info;

-- 会员表序列
create sequence sequence1 
increment by 1
start with 0
maxvalue 99999
minvalue 0
nocycle
nocache


-- 3、菜品类别表
create table Greens_Classes(
    Gr_Id int primary key,                 --菜品ID、主键  
    Gr_Sort varchar2(10) not null unique   --菜品类别
)

-- 类别表序列
create sequence sequence_classes
increment by 1
start with 0
maxvalue 99999
minvalue 0
nocycle
nocache

select * from(select t.*,rownum rn from Greens_Classes t order by Gr_Id) m where m.rn between 1 and 5;



insert into Greens_Classes values(1, '西餐');
insert into Greens_Classes values(2, '粤菜');
insert into Greens_Classes values(3, '川菜');
insert into Greens_Classes values(4, '中餐');

select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice , Menu_memberPrice,Gr_Sort ,Menu_upPhoto  from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id order by Menu_Id;

-- 4、菜单信息表
create table Menu_Info(
	  Menu_Id int primary key,               --菜单主键
    Menu_Name varchar2(20) not null unique,--菜品名称
    Menu_Rmaterial varchar2(20),           --原料
    Menu_marketPrice number(5,2),         --市场价格
    Menu_memberPrice number(5,2),         --会员价格
    Menu_Gr_Id int references Greens_Classes(Gr_Id),  --菜品类别、外键
    Menu_fState varchar2(200),             --菜品说明
    Menu_upPhoto varchar2(60)              --上传图片
) 

select * from Menu_Info;

select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice , Menu_memberPrice,Gr_Sort ,Menu_upPhoto,menu_fState  from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id order by Menu_Id

-- 下面三行是分页测试
select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice , Menu_memberPrice,Gr_Sort ,Menu_upPhoto,menu_fState 
 from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id order by Menu_Id;
 
 select * from (select t.*,rownum rn from (select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice , Menu_memberPrice,Gr_Sort ,Menu_upPhoto,menu_fState 
 from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id order by Menu_Id) t order by t.Menu_Id) m where m.rn between 1 and 5;
 
 select * from (select Order_Info.*,rownum rn from Order_Info order by Ord_Id asc)t where t.rn between ? and ?

-- 菜单表序列
create sequence sequence2
increment by 1
start with 0
maxvalue 99999
minvalue 0
nocycle
nocache

select * from (select Menu_Info.*,rownum rn from Menu_Info order by Menu_Id asc) t where t.rn>1*6 and rn<=2*6

select * from (select Menu_Info.*,rownum rn from Menu_Info order by Menu_Id asc) t where t.rn>0*6 and rn<=(0+1)*6

select rownum from Menu_Info; 
select * from Menu_Info; 

insert into Menu_Info values(1,'红烧肉','猪肉、山楂',40,36,1,'肉吃吃吃','/Public/dishimg/01.jpg');
insert into Menu_Info values(2,'汉堡包','面包、鸡肉、青菜',40,36,1,'肉吃吃吃','/Public/dishimg/02.jpg');
insert into Menu_Info values(3,'披萨','面包、火腿',40,36,1,'肉吃吃吃','/Public/dishimg/03.jpg');
insert into Menu_Info values(4,'东坡肉','猪肉、面粉',40,36,1,'肉吃吃吃','/Public/dishimg/04.jpg');
insert into Menu_Info values(5,'驴肉火烧','面粉、驴肉',40,36,1,'肉吃吃吃','/Public/dishimg/05.jpg');
insert into Menu_Info values(6,'包子','猪肉、面粉',40,36,1,'肉吃吃吃','/Public/dishimg/06.jpg');

select * from Menu_Info order by Menu_Id;

insert into Menu_Info values(sequence2.nextval, 'ds', 'fds', '23', '54', 2, 'fdsdfs', '/Public/dishimg/06.jpg');

insert into Menu_Info values(sequence2.nextval, '北京烤鸭', '鸭肉、酱料', 88.00, 32.00, 3, '非常好吃', '/public/dishimg/06.jpg');

select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice, Menu_memberPrice,Gr_Sort ,Menu_upPhoto,menu_fState  from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id where Menu_Id = '2' order by Menu_Id;


-- 5、公告信息表
create table Notice(
    No_Id int primary key,
    No_Title varchar2(20) not null unique, --公告标记
    No_Message varchar2(100) not null,      --公告内容
    No_time date default sysDate
)


-- 公告表序列
create sequence sequence_Notice
increment by 1
start with 0
maxvalue 99999
minvalue 0
nocycle
nocache

select * from Notice order by No_Id desc;

update Notice set No_Title = '11', No_Message = '22', No_time = sysdate where No_Id = '4';



-- 6、销售订单信息列表
create table Order_Info(
    Ord_Id int primary key,          --用户ID
    Ord_Name varchar2(10) not null,  --用户姓名
    Ord_Tel int,                     --联系方式
    Ord_Address varchar2(50),        --家庭住址
    Ord_grName varchar2(20),         --菜品名称
    Ord_Num int,                     --订购数量
    Ord_Unitprice varchar2(10),      --单价
    Ord_Time date default sysdate,   --订购时间
    Ord_Send varchar2(2) default('是') check(Ord_Send in ('是','否')),  --是否派送
    Ord_Confirm varchar2(10)         --确认订单
)



select * from Order_Info order by Ord_Id desc;

select * from Order_Info where Ord_Name = '小灰灰';

select Ord_grName,count(Ord_grName) num from Order_Info group by Ord_grName order by num desc;

select * from (select * from Order_Info where Ord_Name = '小灰灰') t
 inner join 
(select Ord_grName,count(Ord_grName) from (select * from Order_Info where Ord_Name = '小灰灰') t group by Ord_grName) m on t.Ord_grName = m.Ord_grName;



//分页测试语句

  select * from (select t.*,rownum rn2 from (select m.*,rownum rn from Order_Info m where Ord_Name =  '小灰灰' order by Ord_Time desc) t) n where n.rn2 between 1 and 5;
  
  
insert into Order_Info values(sequence_Order.Nextval, '小灰灰', 12345678966, '飞洒奋斗三年', '地方撒', '1', '34',to_date('2017-07-05 12:11:22','yyyy-MM-dd hh24:mi:ss') , '是', '已确认');

-- 销售订单表序列
create sequence sequence_Order
increment by 1
start with 0
maxvalue 99999
minvalue 0
nocycle
nocache

insert into Order_info values(sequence_Order.Nextval,'张三',13866445388,'空山','西红石炒蛋',5,'12','60',to_date('2017-07-05 12:11:22','yyyy-MM-dd hh24:mi:ss'),'是','已确认');
insert into Order_info values(sequence_Order.Nextval,'李四',13864348668,'山西','凉瓜',5,'12','60',to_date('2017-07-05 12:11:22','yyyy-MM-dd hh24:mi:ss'),'是','已确认');
insert into Order_info values(sequence_Order.Nextval,'霍建华',13866789108,'武汉光谷','红烧肉1',5,'12','60',to_date('2017-07-05 12:11:22','yyyy-MM-dd hh24:mi:ss'),'是','已确认');
insert into Order_info values(sequence_Order.Nextval,'霍华',13866789108,'武汉光谷','红烧肉2',5,'12','60',to_date('2017-07-06 12:11:22','yyyy-MM-dd hh24:mi:ss'),'是','已确认');
insert into Order_info values(sequence_Order.Nextval,'建1',13866789108,'武汉光谷','红烧肉3',5,'12','60',to_date('2017-07-07 12:11:22','yyyy-MM-dd hh24:mi:ss'),'是','已确认');
insert into Order_info values(sequence_Order.Nextval,'建1',13866789108,'武汉光谷','红烧肉3',5,'12','60',to_date('2017-08-02 12:11:22','yyyy-MM-dd hh24:mi:ss'),'是','已确认');


-- 7、餐车表
create table Order_Car (
       Car_Id int primary key,              -- 餐车ID
       Car_Mem_Name varchar(15) not null,   --用户名
       Car_Mem_Tel int not null,            --用户电话
       Car_Address varchar(100) not null,   --用户地址
       Car_Dish_Name varchar(20) not null,  -- 菜名
       Car_Order_Num int not null,          --订单数量
       Car_Order_Price varchar(10) not null,  --订购价格
       Car_Time date default sysdate,       --订购时间
       Car_Confirm int default(0)           --确认订单  
);



-- 餐车表序列
create sequence sequence_Car
increment by 1
start with 0
maxvalue 99999
minvalue 0
nocycle
nocache

insert into Order_Car values(sequence_Car.Nextval, '用户1', 12345678952, '武汉', '水煮鱼', 1, '12',to_date('2017-08-02 12:11:22','yyyy-MM-dd hh24:mi:ss'), 0);


insert into Order_Car(Car_Id, Car_Mem_Name, Car_Mem_Tel, Car_Address, Car_Dish_Name, Car_Order_Num, Car_Order_Price, Car_Confirm) values(sequence_Car.Nextval, '小灰灰', 123025612321255, '河北省倒萨', '范德萨', '1', '34', '0');
		
select * from Order_Car;
select Car_Dish_Name,sum(Car_Dish_Name) from Order_Car group by Car_Dish_Name having Car_Mem_Name = '小灰灰';

select * from Order_Car where Car_Mem_Name = '小灰灰';

select Car_Dish_Name,count(Car_Dish_Name) from (select * from Order_Car where Car_Mem_Name = '小灰灰') group by Car_Dish_Name;


select min(Car_Id) from Order_Car where Car_Mem_Name='小灰灰' and Car_Dish_Name='红烧';

delete from Order_Car where Car_Mem_Name = '哈哈';

select * from Order_Car where Car_Mem_Name = '小灰灰';

-- 8、配送指南
create table Distribution(
    Dis_Atime1 varchar2(20),
    Dis_Atime2 varchar2(20),
    Dis_Dtime1 varchar2(20),
    Dis_Dtime2 varchar2(20),
    Dis_Tel varchar2(11),
    Dis_People varchar2(80),
    Dis_Remark varchar2(300)
)

insert into Distribution values('11:00','14:00','17:00','21:00','13868686868','祁燕辉','阿萨德哈阿斯达斯的哈师大会拿出男才女貌年请问好久没你看了就打开卡我的家阿喀琉斯决定卡拉胶三度空间阿斯卡斯柯达晶绿卡时间的卡视角');


select * from Distribution;

select * from (select Order_Info.*,rownum rn from Order_Info order by Ord_Id asc)t where t.rn>1*5 and rn<=2*5

select Order_Info.*,rownum rn from Order_Info order by Ord_Id asc