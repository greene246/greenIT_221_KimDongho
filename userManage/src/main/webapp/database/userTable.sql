create database firstJsp;

use firstJsp;
create table users(
`id` varchar(20) primary key,
`pw` varchar(20) not null,
`name` varchar(20) not null,
`gender` varchar(4),
`birthdate` datetime not null,
`email` varchar(40) not null,
`country` varchar(10) not null,
`mobile` varchar(13) not null
);

create table board(
	`no` int not null,
    `code` int primary key, -- 4자리 랜덤숫자
    title varchar(100) not null,
    contents varchar(1000) not null,
    viewCnt int default 0,
    likeCnt int default 0,
    createdAt datetime,
    modifiedAt datetime
);