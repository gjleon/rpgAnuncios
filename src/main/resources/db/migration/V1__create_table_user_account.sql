CREATE TABLE user_accounts (
id bigint AUTO_INCREMENT NOT NULL,
email VARCHAR(255) NOT NULL,
login VARCHAR(255) NOT NULL,
nick_discord VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
primary key (id)) engine=InnoDB