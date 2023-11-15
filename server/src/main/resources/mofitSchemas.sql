DROP DATABASE IF EXISTS mofit;
CREATE DATABASE mofit;
USE mofit;

CREATE TABLE `user` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`email` VARCHAR(30) NOT NULL UNIQUE,
    `password` VARCHAR(20) NOT NULL,
    `name` VARCHAR(10) NOT NULL,
    `nickname` VARCHAR(10) NOT NULL UNIQUE,
    `img` VARCHAR(30) NULL
);

CREATE TABLE `group` (
	`group_id` INT PRIMARY KEY AUTO_INCREMENT,
	`group_name` VARCHAR(20) NOT NULL UNIQUE,
    `type` VARCHAR(10) NOT NULL,
    `info` VARCHAR(300) NULL,
    `profile_img` VARCHAR(30) NULL,
    `cover_img` VARCHAR(30) NULL
);

CREATE TABLE `group_region` (
	`group_id` INT NOT NULL,
    `region` VARCHAR(10) NOT NULL,
    FOREIGN KEY (group_id) REFERENCES `group`(group_id)
);

CREATE TABLE `group_member` (
	`user_id` INT NOT NULL,
    `group_id` INT NOT NULL,
    `grade` ENUM('일반회원', '운영진') NOT NULL,
    FOREIGN KEY (user_id) REFERENCES `user`(id),
    FOREIGN KEY (group_id) REFERENCES `group`(group_id)
);

CREATE TABLE `follow` (
	`follower` INT NOT NULL,
    `following` INT NOT NULL,
    FOREIGN KEY (follower) REFERENCES `user`(id),
    FOREIGN KEY (following) REFERENCES `user`(id)
);

CREATE TABLE `notice` (
  `index` INT PRIMARY KEY AUTO_INCREMENT,
  `group_id` INT NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` VARCHAR(300) NOT NULL,
  `writer` INT NOT NULL,
  `date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (group_id) REFERENCES `group`(group_id),
  FOREIGN KEY (writer) REFERENCES `user`(id)
);

CREATE TABLE `board` (
  `index` INT PRIMARY KEY AUTO_INCREMENT,
  `group_id` INT NOT NULL,
  `content` VARCHAR(300) NOT NULL,
  `writer` INT NOT NULL,
  `date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (group_id) REFERENCES `group`(group_id),
  FOREIGN KEY (writer) REFERENCES `user`(id)
);

CREATE TABLE `gallery` (
  `index` INT PRIMARY KEY AUTO_INCREMENT,
  `group_id` INT NOT NULL,
  `content` VARCHAR(300) NOT NULL,
  `writer` INT NOT NULL,
  `date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `img` BLOB NOT NULL,
  FOREIGN KEY (group_id) REFERENCES `group`(group_id),
  FOREIGN KEY (writer) REFERENCES `user`(id)
);

CREATE TABLE `comment_notice` (
  `comment_idx`INT PRIMARY KEY AUTO_INCREMENT,
  `notice_idx` INT NOT NULL,
  `content` VARCHAR(300) NOT NULL,
  `writer` INT NOT NULL,
  `date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (`notice_idx`) REFERENCES `notice`(`index`),
  FOREIGN KEY (writer) REFERENCES `user`(id)
);

CREATE TABLE `comment_board` (
  `comment_idx`INT PRIMARY KEY AUTO_INCREMENT,
  `board_idx` INT NOT NULL,
  `content` VARCHAR(300) NOT NULL,
  `writer` INT NOT NULL,
  `date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (`board_idx`) REFERENCES `board`(`index`),
  FOREIGN KEY (writer) REFERENCES `user`(id)
);

CREATE TABLE `comment_gallery` (
  `comment_idx`INT PRIMARY KEY AUTO_INCREMENT,
  `gallery_idx` INT NOT NULL,
  `content` VARCHAR(300) NOT NULL,
  `writer` INT NOT NULL,
  `date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (`gallery_idx`) REFERENCES `gallery`(`index`),
  FOREIGN KEY (writer) REFERENCES `user`(id)
);

CREATE TABLE `video` (
  `index` INT PRIMARY KEY AUTO_INCREMENT,
  `url` INT NOT NULL UNIQUE,
  `type` VARCHAR(10) NOT NULL
);

CREATE TABLE `bookmark` (
  `user_id` INT NOT NULL, 
  `url` INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES `user`(id), 
  FOREIGN KEY (url) REFERENCES `video`(url) 
);