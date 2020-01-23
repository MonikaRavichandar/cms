-- creating Database
create database MLP192;

-- using the Database
use MLP192;

-- Creating Customer Table
--create table CUSTOMERS

create table CUSTOMER(CUS_ID varchar(30) primary key not null,CUS_PWD varchar(20),CUS_NAME varchar(30),CUS_PH varchar(20),CUS_ADD varchar(30));
--create table VENDOR

create table VENDOR(VEN_ID varchar(20) primary key,CUS_ID varchar(20),VEN_NAME varchar(20),VEN_FSTATUS varchar(20),VEN_NO varchar(20) , foreign key(CUS_ID) references CUSTOMER(CUS_ID) on delete cascade);
--create table ORDERS

create table ORDERS(CUS_ID varchar(20),ORD_ID int primary key not null,ORD_DATE datetime,ORD_TIME datetime,ORD_ITEMSEL varchar(20),foreign key(CUS_ID) references CUSTOMER(CUS_ID) on delete cascade);
--create table WALLET

create table WALLET(CUS_ID varchar(20),WAL_BAL float,WAL_PAYID varchar(20),WAL_TOTAMT float,WAL_PAYDATE datetime,WAL_PAYTIME datetime,foreign key(CUS_ID) references CUSTOMER(CUS_ID) on delete cascade);
--create table MENU

create table MENU(MEN_ITEMNAME varchar(20),MEN_ITEMID varchar(20) primary key,MEN_ITEMAMT float,CUS_ID varchar(20),foreign key(CUS_ID) references CUSTOMER(CUS_ID) on delete cascade);
