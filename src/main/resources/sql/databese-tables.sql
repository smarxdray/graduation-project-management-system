DROP DATABASE IF EXISTS `gpms`;

CREATE DATABASE`gpms`;

USE `gpms`;

CREATE TABLE IF NOT EXISTS `college`(
    `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(16) NOT NULL UNIQUE,
	`major_number` INT UNSIGNED,
	`teacher_number` INT UNSIGNED,
	`student_number` INT UNSIGNED,
    `desc` VARCHAR(128),
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `major`(
    `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `code` VARCHAR(16) NOT NULL UNIQUE,
    `name` VARCHAR(16) NOT NULL,
    `desc` VARCHAR(128),
    `class_number` INT UNSIGNED,
    `teacher_number` INT UNSIGNED,
    `student_number` INT UNSIGNED,
    `college` INT UNSIGNED NOT NULL,
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (`college`) REFERENCES `college`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `teacher_title`(
    `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(16) NOT NULL UNIQUE
    	COMMENT '职称：教授，副教授，讲师等',
    `desc` VARCHAR(128),
    `number` INT UNSIGNED,
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `role`(
	`id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(16) NOT NULL UNIQUE
	    COMMENT 'admin, teacher, student, visitor',
	`desc` VARCHAR(128),
	`type` INT UNSIGNED DEFAULT 0
		COMMENT '0：元角色（用户不可编辑、删除，如admin）
				 1：普通角色',
	`status` INT DEFAULT 0
		COMMENT '-1：禁用
				 0：正常',
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user`(
	 `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	 `name` VARCHAR(16) NOT NULL,
	 `gender` TINYINT DEFAULT 0
		 COMMENT '0：未知
				  1：男
				  2：女',
	 `role` INT UNSIGNED NOT NULL,
	 `status` INT DEFAULT 0
		 COMMENT '-1：禁用
       			   0：正常',
	 `code` VARCHAR(16) UNIQUE,
	 `phone` VARCHAR(16) UNIQUE,
	 `email` VARCHAR(32) UNIQUE,
	 `openid` VARCHAR(32),
	 `desc` VARCHAR(128),
	 `avatar_uri` VARCHAR(128),
	 `salt` VARCHAR(64),
	 `password` VARCHAR(64),
	 `comment_disabled` TINYINT(1) DEFAULT 0
		 COMMENT '禁用功能：评论',
	 `notify_disabled` TINYINT(1) DEFAULT 0
		 COMMENT '禁用功能：发通知',
	 `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	 `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	 FOREIGN KEY (`role`) REFERENCES `role`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `project`(
	`id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`teacher` INT UNSIGNED NOT NULL,
	`title` VARCHAR(32) NOT NULL,
	`content` LONGTEXT NOT NULL,
	`status` INT DEFAULT 0
		COMMENT '0: 待审核
				 1：审核通过
                 10：审核通过，未认领
                 11: 审核通过已认领',
	`student` INT UNSIGNED,
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (`teacher`) REFERENCES `user`(`id`),
	FOREIGN KEY (`student`) REFERENCES `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `admin`(
    `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `owner` INT UNSIGNED NOT NULL UNIQUE,
    `level` INT UNSIGNED DEFAULT 1
     	COMMENT '0：元管理账号（用户不可编辑、删除）
     			 1：一级管理账号
     			 2：二级管理账号
     			 高级账号可编辑、删除低级账号
     			 同级账号间不可相互编辑、删除
     			 元管理账号可编辑、删除其他账号',
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (`owner`) REFERENCES `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `teacher`(
    `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `owner` INT UNSIGNED NOT NULL UNIQUE,
    `title` INT UNSIGNED,
    `college` INT UNSIGNED,
	`major` INT UNSIGNED,
    `student_number` INT UNSIGNED DEFAULT 0
        COMMENT '指导的学生人数',
    `student_mark` INT UNSIGNED
    	COMMENT '学生评分（5分制）',
	`accept_disabled` TINYINT(1) DEFAULT 0
		COMMENT '禁用功能：接收学生',
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (`owner`) REFERENCES `user`(`id`),
    FOREIGN KEY (`title`) REFERENCES `teacher_title`(`id`),
    FOREIGN KEY (`college`) REFERENCES `college`(`id`),
	FOREIGN KEY (`major`) REFERENCES `major`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `student`(
	`id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`owner` INT UNSIGNED NOT NULL,
	`teacher` INT UNSIGNED,
	`status` INT DEFAULT 0
		COMMENT '0：未分配导师，未分配课题
				 10：已分配导师，未分配课题
                 11：已分配导师，已分配课题，毕设审核中
                 110：毕设审核未通过
                 111：毕设审核通过',
	`project` INT UNSIGNED,
	`file_dir` VARCHAR(128),
    `review_times` INT UNSIGNED DEFAULT 0,
    `college` INT UNSIGNED,
    `major` INT UNSIGNED,
    `gpa` FLOAT(4),
    `address` VARCHAR(64),
	`allotted_disabled` TINYINT(1) DEFAULT 0
		COMMENT '禁用功能：被分配',
	`commit_disabled` TINYINT(1) DEFAULT 0
		COMMENT '禁用功能：提交毕设文件',
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (`owner`) REFERENCES `user`(`id`),
	FOREIGN KEY (`teacher`) REFERENCES `user`(`id`),
	FOREIGN KEY (`project`) REFERENCES `project`(`id`),
	FOREIGN KEY (`college`) REFERENCES `college`(`id`),
	FOREIGN KEY (`major`) REFERENCES `major`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `notice`(
   `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
   `title` VARCHAR(32) NOT NULL,
   `author` INT UNSIGNED NOT NULL,
   `reviewer` INT UNSIGNED,
   `content_short` VARCHAR(64)
        COMMENT '摘要',
   `content` LONGTEXT,
   `importance` TINYINT DEFAULT 0,
   `type` INT UNSIGNED NOT NULL
	   COMMENT '0: 全体师生(含管理员）
				1：全体导师
				2：全体学生
				3：本人全体学生
				4：管理员私信
				5：导师私信
				6：学生私信',
   `status` INT NOT NULL
	   COMMENT '-1：已移除
				 0：草稿
				 1：已发布',
   `display_time` DATETIME,
   `comment_disabled` TINYINT(1) DEFAULT 0,
   `view_times` INT UNSIGNED DEFAULT 0
	   COMMENT '阅读人数',
   `img_uri` VARCHAR(128),
   `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   FOREIGN KEY (`author`) REFERENCES `user`(`id`),
   FOREIGN KEY (`reviewer`) REFERENCES `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `private_notice`(
    `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `owner` INT UNSIGNED NOT NULL,
    `receiver` INT UNSIGNED,
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (`owner`) REFERENCES `notice`(`id`),
	FOREIGN KEY (`receiver`) REFERENCES `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `comment`(
	`id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`author` INT UNSIGNED NOT NULL,
	`mark` INT UNSIGNED
		COMMENT '5分制（对导师的评价）
				 100分制（给学生的评语，成绩）',
	`content_short` VARCHAR(64)
		COMMENT '摘要',
	`content` LONGTEXT,
	`type` INT UNSIGNED NOT NULL
		COMMENT '0：对程序（feedback）
    			 1：对评论（reply）
    			 2：对通知
    			 3：对用户（导师评价，学生成绩）',
	`status` INT DEFAULT 0
		COMMENT '-2：匿名
				 -1：移除
    			 0：普通
    			 1：置顶',
	`target` INT UNSIGNED
		COMMENT '引用表：comment, notice, user 或 NULL（程序反馈）',
	`comment_disabled` TINYINT(1) DEFAULT 1,
	`view_times` INT UNSIGNED DEFAULT 0
		COMMENT '阅读人数',
	`img_uri` VARCHAR(128),
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (`author`) REFERENCES `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `file`(
   `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
   `owner` INT UNSIGNED NOT NULL,
   `name` VARCHAR(32),
   `extension` VARCHAR(8),
   `path` VARCHAR(128) NOT NULL
        COMMENT '/dir/name.extension',
   `size` INT UNSIGNED,
   `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   FOREIGN KEY (`owner`) REFERENCES `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `management`(
	 `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	 `item` VARCHAR(32) NOT NULL,
	 `val` INT NOT NULL,
	 `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	 `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;