create schema library collate latin1_swedish_ci;

create table admin
(
	id int auto_increment
		primary key,
	Adname varchar(10) charset utf8 default 'root' null,
	psw varchar(16) charset utf8 default '123' null,
	constraint admin_Adname_uindex
		unique (Adname)
);

create table book
(
	bkId int auto_increment
		primary key,
	bkName varchar(20) charset utf8 null,
	bkAuthor varchar(30) charset utf8 null,
	bkPress varchar(50) charset utf8 null,
	bkDatePress datetime null,
	bkCatalog varchar(15) charset utf8 null,
	bkISBN varchar(10) charset utf8 null,
	bkLanguage int null,
	bkPages int null,
	bkPrice int null,
	bkDateIn datetime null,
	bkBrief varchar(1000) charset utf8 null,
	bkCover varchar(255) charset utf8 null,
	bkStatus char(2) charset utf8 null,
	bkCode varchar(30) charset utf8 not null
);

create table readertype
(
	rdType smallint not null
		primary key,
	rdTypeName varchar(20) not null,
	CanLendQty int not null,
	CanLendDay int(255) null,
	CanContinueTimes int null,
	PunishRate float null,
	DateValid smallint default 0 not null,
	constraint rdTypeName
		unique (rdTypeName)
)
charset=utf8;

create table reader
(
	rdId int default 0 not null
		primary key,
	rdName varchar(20) charset utf8 null,
	rdSex char charset utf8 null,
	rdType smallint not null,
	rdDept varchar(25) charset utf8 null,
	rdPhone varchar(25) charset utf8 null,
	rdEmil varchar(25) charset utf8 null,
	rdDateReg datetime null,
	rdPhoto varchar(255) charset utf8 null,
	rdStatus char(255) charset utf8 null,
	rdBorrowQty int default 0 null,
	rdPwd varchar(25) charset utf8 null,
	rdAdminRoles smallint null,
	constraint rdType
		foreign key (rdType) references readertype (rdType)
);

create table borrow
(
	BorrowID int(10) auto_increment
		primary key,
	rdID int null,
	bkID int null,
	idCountinueTimes int default 0 null,
	ldDateOut datetime null,
	ldDateRetPlan datetime null,
	ldDateRetAct datetime null,
	ldOverDay int default 0 null,
	ldOverMoney int default 0 null,
	IsHasReturn tinyint(1) default 0 null,
	OperatorLend varchar(20) charset utf8 null,
	OperatorRet varchar(20) charset utf8 null,
	bookname varchar(20) null,
	authorname varchar(20) null,
	constraint bkId
		foreign key (bkID) references book (bkId),
	constraint rdID
		foreign key (rdID) references reader (rdId)
);

create table test
(
	id int auto_increment
		primary key,
	name varchar(10) charset utf8 null,
	num int null
);

