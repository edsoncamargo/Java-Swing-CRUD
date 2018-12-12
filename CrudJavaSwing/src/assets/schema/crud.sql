/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  edson
 * Created: 11/12/2018
 */

create database crud;

use crud;

create table tb_user (
	ID int not null auto_increment,
    UserName varchar(15) not null unique,
    Name varchar(35) not null,
    Birth varchar(10),
    Password varchar(35) not null,
    primary key (ID)
);

select * from tb_user;
