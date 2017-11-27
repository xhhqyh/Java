-- 1������Ա��Ϣ��
create table Admin_Info(
    Adm_Id int primary key,                --�û�ID������  
    Adm_Name varchar2(10) not null,        --�û���
    Adm_Psw varchar2(20) not null,         --����
    Adm_Remark varchar2(50)                --��ע��Ϣ
)

select * from Admin_Info;

insert into Admin_Info values(1, 'Admin', '123456', '���ǳ�������Ա���ʺ���Ϣ��ӵ�����Ȩ��');

select * from Admin_Info where Adm_Name = 'Admin' and Adm_Psw ='123456';


-- 2����Ա��Ϣ��
create table Member_Info(
  	Mem_Id int primary key,                --��ԱId (����)
    Mem_Name varchar2(20) not null unique, --�û���
    Mem_Psw varchar2(20) not null,         --����
    Mem_Trname varchar2(20) not null,      --��ʵ����
    Mem_Sex int default('1') check(Mem_Sex in ('1','0')),   --�Ա�
    Mem_Birthday date,                     --����
    Mem_Address varchar2(50),              --��ͥסַ
    Mem_Tel int,                           --�绰����
    Mem_Email varchar2(20)                 --��������
)

insert into Member_Info values(sequence1.nextval,'������ս','1438','������',1,to_date('1991-10-07','yyyy-MM-dd'),'�Ͼ���',1388886666,'14725836@qq.com');
insert into Member_Info values(sequence1.nextval,'������','1438','������',1,to_date('1991-10-07','yyyy-MM-dd'),'�Ͼ���',1388886666,'14725836@qq.com');
insert into Member_Info values(sequence1.nextval,'����ս','1438','������',1,to_date('1991-10-07','yyyy-MM-dd'),'�Ͼ���',1388886666,'14725836@qq.com');
insert into Member_Info values(sequence1.nextval,'����ս','1438','������',1,to_date('1991-10-07','yyyy-MM-dd'),'�Ͼ���',1388886666,'14725836@qq.com');
insert into Member_Info values(sequence1.nextval,'����ս','1438','������',1,to_date('1991-10-07','yyyy-MM-dd'),'�Ͼ���',1388886666,'14725836@qq.com');
insert into Member_Info values(sequence1.nextval,'d������ս','1438','������',1,to_date('1991-10-07','yyyy-MM-dd'),'�Ͼ���',1388886666,'14725836@qq.com');
insert into Member_Info values(sequence1.nextval,'fg������ս','1438','������',1,to_date('1991-10-07','yyyy-MM-dd'),'�Ͼ���',1388886666,'14725836@qq.com');
select * from Member_Info;

-- ��Ա������
create sequence sequence1 
increment by 1
start with 0
maxvalue 99999
minvalue 0
nocycle
nocache


-- 3����Ʒ����
create table Greens_Classes(
    Gr_Id int primary key,                 --��ƷID������  
    Gr_Sort varchar2(10) not null unique   --��Ʒ���
)

-- ��������
create sequence sequence_classes
increment by 1
start with 0
maxvalue 99999
minvalue 0
nocycle
nocache

select * from(select t.*,rownum rn from Greens_Classes t order by Gr_Id) m where m.rn between 1 and 5;



insert into Greens_Classes values(1, '����');
insert into Greens_Classes values(2, '����');
insert into Greens_Classes values(3, '����');
insert into Greens_Classes values(4, '�в�');

select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice , Menu_memberPrice,Gr_Sort ,Menu_upPhoto  from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id order by Menu_Id;

-- 4���˵���Ϣ��
create table Menu_Info(
	  Menu_Id int primary key,               --�˵�����
    Menu_Name varchar2(20) not null unique,--��Ʒ����
    Menu_Rmaterial varchar2(20),           --ԭ��
    Menu_marketPrice number(5,2),         --�г��۸�
    Menu_memberPrice number(5,2),         --��Ա�۸�
    Menu_Gr_Id int references Greens_Classes(Gr_Id),  --��Ʒ������
    Menu_fState varchar2(200),             --��Ʒ˵��
    Menu_upPhoto varchar2(60)              --�ϴ�ͼƬ
) 

select * from Menu_Info;

select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice , Menu_memberPrice,Gr_Sort ,Menu_upPhoto,menu_fState  from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id order by Menu_Id

-- ���������Ƿ�ҳ����
select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice , Menu_memberPrice,Gr_Sort ,Menu_upPhoto,menu_fState 
 from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id order by Menu_Id;
 
 select * from (select t.*,rownum rn from (select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice , Menu_memberPrice,Gr_Sort ,Menu_upPhoto,menu_fState 
 from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id order by Menu_Id) t order by t.Menu_Id) m where m.rn between 1 and 5;
 
 select * from (select Order_Info.*,rownum rn from Order_Info order by Ord_Id asc)t where t.rn between ? and ?

-- �˵�������
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

insert into Menu_Info values(1,'������','���⡢ɽ�',40,36,1,'��ԳԳ�','/Public/dishimg/01.jpg');
insert into Menu_Info values(2,'������','��������⡢���',40,36,1,'��ԳԳ�','/Public/dishimg/02.jpg');
insert into Menu_Info values(3,'����','���������',40,36,1,'��ԳԳ�','/Public/dishimg/03.jpg');
insert into Menu_Info values(4,'������','���⡢���',40,36,1,'��ԳԳ�','/Public/dishimg/04.jpg');
insert into Menu_Info values(5,'¿�����','��ۡ�¿��',40,36,1,'��ԳԳ�','/Public/dishimg/05.jpg');
insert into Menu_Info values(6,'����','���⡢���',40,36,1,'��ԳԳ�','/Public/dishimg/06.jpg');

select * from Menu_Info order by Menu_Id;

insert into Menu_Info values(sequence2.nextval, 'ds', 'fds', '23', '54', 2, 'fdsdfs', '/Public/dishimg/06.jpg');

insert into Menu_Info values(sequence2.nextval, '������Ѽ', 'Ѽ�⡢����', 88.00, 32.00, 3, '�ǳ��ó�', '/public/dishimg/06.jpg');

select Menu_Id,Menu_Name, Menu_Rmaterial,Menu_marketPrice, Menu_memberPrice,Gr_Sort ,Menu_upPhoto,menu_fState  from Menu_Info a left join Greens_Classes b on a.Menu_Gr_Id = b.Gr_Id where Menu_Id = '2' order by Menu_Id;


-- 5��������Ϣ��
create table Notice(
    No_Id int primary key,
    No_Title varchar2(20) not null unique, --������
    No_Message varchar2(100) not null,      --��������
    No_time date default sysDate
)


-- ���������
create sequence sequence_Notice
increment by 1
start with 0
maxvalue 99999
minvalue 0
nocycle
nocache

select * from Notice order by No_Id desc;

update Notice set No_Title = '11', No_Message = '22', No_time = sysdate where No_Id = '4';



-- 6�����۶�����Ϣ�б�
create table Order_Info(
    Ord_Id int primary key,          --�û�ID
    Ord_Name varchar2(10) not null,  --�û�����
    Ord_Tel int,                     --��ϵ��ʽ
    Ord_Address varchar2(50),        --��ͥסַ
    Ord_grName varchar2(20),         --��Ʒ����
    Ord_Num int,                     --��������
    Ord_Unitprice varchar2(10),      --����
    Ord_Time date default sysdate,   --����ʱ��
    Ord_Send varchar2(2) default('��') check(Ord_Send in ('��','��')),  --�Ƿ�����
    Ord_Confirm varchar2(10)         --ȷ�϶���
)



select * from Order_Info order by Ord_Id desc;

select * from Order_Info where Ord_Name = 'С�һ�';

select Ord_grName,count(Ord_grName) num from Order_Info group by Ord_grName order by num desc;

select * from (select * from Order_Info where Ord_Name = 'С�һ�') t
 inner join 
(select Ord_grName,count(Ord_grName) from (select * from Order_Info where Ord_Name = 'С�һ�') t group by Ord_grName) m on t.Ord_grName = m.Ord_grName;



//��ҳ�������

  select * from (select t.*,rownum rn2 from (select m.*,rownum rn from Order_Info m where Ord_Name =  'С�һ�' order by Ord_Time desc) t) n where n.rn2 between 1 and 5;
  
  
insert into Order_Info values(sequence_Order.Nextval, 'С�һ�', 12345678966, '�����ܶ�����', '�ط���', '1', '34',to_date('2017-07-05 12:11:22','yyyy-MM-dd hh24:mi:ss') , '��', '��ȷ��');

-- ���۶���������
create sequence sequence_Order
increment by 1
start with 0
maxvalue 99999
minvalue 0
nocycle
nocache

insert into Order_info values(sequence_Order.Nextval,'����',13866445388,'��ɽ','����ʯ����',5,'12','60',to_date('2017-07-05 12:11:22','yyyy-MM-dd hh24:mi:ss'),'��','��ȷ��');
insert into Order_info values(sequence_Order.Nextval,'����',13864348668,'ɽ��','����',5,'12','60',to_date('2017-07-05 12:11:22','yyyy-MM-dd hh24:mi:ss'),'��','��ȷ��');
insert into Order_info values(sequence_Order.Nextval,'������',13866789108,'�人���','������1',5,'12','60',to_date('2017-07-05 12:11:22','yyyy-MM-dd hh24:mi:ss'),'��','��ȷ��');
insert into Order_info values(sequence_Order.Nextval,'����',13866789108,'�人���','������2',5,'12','60',to_date('2017-07-06 12:11:22','yyyy-MM-dd hh24:mi:ss'),'��','��ȷ��');
insert into Order_info values(sequence_Order.Nextval,'��1',13866789108,'�人���','������3',5,'12','60',to_date('2017-07-07 12:11:22','yyyy-MM-dd hh24:mi:ss'),'��','��ȷ��');
insert into Order_info values(sequence_Order.Nextval,'��1',13866789108,'�人���','������3',5,'12','60',to_date('2017-08-02 12:11:22','yyyy-MM-dd hh24:mi:ss'),'��','��ȷ��');


-- 7���ͳ���
create table Order_Car (
       Car_Id int primary key,              -- �ͳ�ID
       Car_Mem_Name varchar(15) not null,   --�û���
       Car_Mem_Tel int not null,            --�û��绰
       Car_Address varchar(100) not null,   --�û���ַ
       Car_Dish_Name varchar(20) not null,  -- ����
       Car_Order_Num int not null,          --��������
       Car_Order_Price varchar(10) not null,  --�����۸�
       Car_Time date default sysdate,       --����ʱ��
       Car_Confirm int default(0)           --ȷ�϶���  
);



-- �ͳ�������
create sequence sequence_Car
increment by 1
start with 0
maxvalue 99999
minvalue 0
nocycle
nocache

insert into Order_Car values(sequence_Car.Nextval, '�û�1', 12345678952, '�人', 'ˮ����', 1, '12',to_date('2017-08-02 12:11:22','yyyy-MM-dd hh24:mi:ss'), 0);


insert into Order_Car(Car_Id, Car_Mem_Name, Car_Mem_Tel, Car_Address, Car_Dish_Name, Car_Order_Num, Car_Order_Price, Car_Confirm) values(sequence_Car.Nextval, 'С�һ�', 123025612321255, '�ӱ�ʡ����', '������', '1', '34', '0');
		
select * from Order_Car;
select Car_Dish_Name,sum(Car_Dish_Name) from Order_Car group by Car_Dish_Name having Car_Mem_Name = 'С�һ�';

select * from Order_Car where Car_Mem_Name = 'С�һ�';

select Car_Dish_Name,count(Car_Dish_Name) from (select * from Order_Car where Car_Mem_Name = 'С�һ�') group by Car_Dish_Name;


select min(Car_Id) from Order_Car where Car_Mem_Name='С�һ�' and Car_Dish_Name='����';

delete from Order_Car where Car_Mem_Name = '����';

select * from Order_Car where Car_Mem_Name = 'С�һ�';

-- 8������ָ��
create table Distribution(
    Dis_Atime1 varchar2(20),
    Dis_Atime2 varchar2(20),
    Dis_Dtime1 varchar2(20),
    Dis_Dtime2 varchar2(20),
    Dis_Tel varchar2(11),
    Dis_People varchar2(80),
    Dis_Remark varchar2(300)
)

insert into Distribution values('11:00','14:00','17:00','21:00','13868686868','�����','�����¹���˹��˹�Ĺ�ʦ����ó��в�Ůò�����ʺþ�û�㿴�˾ʹ򿪿��ҵļҰ�����˹�������������ȿռ䰢˹��˹�´ﾧ�̿�ʱ��Ŀ��ӽ�');


select * from Distribution;

select * from (select Order_Info.*,rownum rn from Order_Info order by Ord_Id asc)t where t.rn>1*5 and rn<=2*5

select Order_Info.*,rownum rn from Order_Info order by Ord_Id asc