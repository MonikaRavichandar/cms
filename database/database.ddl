-- creating Database
create database MLP192;

-- using the Database
use MLP192;

-- Creating Customer Table

create table CUSTOMER(CUS_ID varchar(30) primary key not null,
CUS_PWD varchar(20),CUS_NAME varchar(30),
CUS_PH int,CUS_ADD varchar(30));

-- Creating VENDOR Table

create table VENDOR(VEN_ID varchar(20) primary key,
CUS_ID varchar(20),VEN_NAME varchar(20),
VEN_FSTATUS varchar(20),VEN_NO int , 
foreign key(CUS_ID) references CUSTOMER(CUS_ID) on delete cascade);

-- Creating ORDERS Table

create table ORDERS(CUS_ID varchar(20),
ORD_ID int primary key not null,ORD_DATE datetime,
ORD_TIME datetime,ORD_ITEMSEL varchar(20),
foreign key(CUS_ID) references CUSTOMER(CUS_ID) on delete cascade);

-- Creating WALLET Table

create table WALLET(CUS_ID varchar(20),WAL_BAL float,
WAL_PAYID varchar(20),WAL_TOTAMT float,
WAL_PAYDATE datetime,WAL_PAYTIME datetime,
foreign key(CUS_ID) references CUSTOMER(CUS_ID) on delete cascade);

-- Creating MENU Table

create table MENU(MEN_ITEMNAME varchar(20),
MEN_ITEMID varchar(20) primary key,MEN_ITEMAMT float,
MEN_ITEMDISP varchar(20),CUS_ID varchar(20),
foreign key(CUS_ID) references CUSTOMER(CUS_ID) on delete cascade);


