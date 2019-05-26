-- we don't know how to generate schema bank_db (class Schema) :(
create table user_bank
(
	id int not null
		primary key,
	user_name varchar(255) null,
	user_email varchar(255) null,
	user_pwd varchar(255) null,
	is_employee tinyint(1) null,
	username varchar(255) null
);