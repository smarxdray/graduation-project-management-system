USE `gpms`;

SET FOREIGN_KEY_CHECKS =0;
TRUNCATE `comment`;
TRUNCATE `private_notice`;
TRUNCATE `notice`;
TRUNCATE `student`;
TRUNCATE `teacher`;
TRUNCATE `admin`;
TRUNCATE `user`;
TRUNCATE `role`;
TRUNCATE `teacher_title`;
TRUNCATE `major`;
TRUNCATE `college`;
TRUNCATE `route_blacklist`;
TRUNCATE `route`;
SET FOREIGN_KEY_CHECKS =1;

INSERT INTO `college`
    ( `name`, `major_number`, `teacher_number`, `student_number`, `desc` )
VALUES
       ( '学院1', 3, 35, 345, '学院1的描述信息' ),
       ( '学院2', 2, 25, 245, '学院2的描述信息' ),
       ( '学院3', 1, 15, 145, '学院3的描述信息' );

INSERT INTO `major`
    ( `code`, `name`, `desc`, `class_number`, `teacher_number`, `student_number`, `college` )
VALUES
       ( '1000000000' , '专业1', '专业1的描述', 5, 8, 45, 1),
       ( '2000000000' , '专业2', '专业2的描述', 5, 8, 45, 1),
       ( '3000000000' , '专业3', '专业3的描述', 5, 8, 45, 1);

INSERT INTO `teacher_title`
    ( `name`, `desc`, `number` )
VALUES
    ( '讲师', '讲师的描述信息', 100 ),
    ( '副教授', '副教授的描述信息', 50 ),
    ( '教授','教授的描述信息', 25 );

INSERT INTO `role`
    ( `name`, `desc`, `type`, `status`)
VALUES
    ( 'admin', 'admin的描述', 0, 0  ),
    ( 'forbidden', 'forbidden的描述', 0, 0 ),
    ( 'visitor', 'visitor的描述', 0, 0 ),
    ( 'teacher', 'teacher的描述', 0, 0 ),
    ( 'student', 'student的描述', 0, 0 );

INSERT INTO `user`
    ( `name`, `gender`, `role`, `status`, `code`, `phone`, `email`, `desc`, `avatar_uri`,
     `salt`, `password` )
VALUES
    ( 'admin', 0, 1, 0, '0000000000', '12345678901', 'admin@mail.com', 'admin的描述信息', NULL,
     '123', '123'),
    ( 'teacher', 0, 4, 0, '1000000000', '12345678901', 'teacher@mail.com', 'admin的描述信息', NULL,
      '123', '123'),
    ( 'student', 0, 5, 0, '2000000000', '12345678901', 'student@mail.com', 'admin的描述信息', NULL,
      '123', '123');

INSERT INTO `admin`
    ( `owner`, `level` )
VALUES
    ( 1, 0 );

INSERT INTO `teacher`
    ( `owner`, `title`,`college`, `major`, `student_number`, `student_mark` )
VALUES
    ( 2, 2, 1, 1, 8, 4 );

INSERT INTO `student`
    ( `owner`, `teacher`, `status`, `project_title`, `file_uri`, `review_times`,
     `college`, `major`, `gpa`, `address` )
VALUES
    ( 3, NULL, 0, NULL, NULL, 0, 1, 1, 3.5, NULL );

INSERT INTO `notice`
    ( `title`, `author`, `reviewer`, `content_short`, `content`, `importance`,
     `type`, `status`, `display_time`, `comment_disabled`, `view_times`, `img_uri` )
VALUES
    ( '通知1', 1, NULL, '通知1摘要', '<h>通知1</h><p>通知1第一段</><p>通知1第二段</>', 0,
     0, 1, '2019-04-02 22:33:44', 0, 25, NULL),
    ( '私信1', 2, NULL, '私信1摘要', '<h>私信1</h><p>私信1第一段</><p>私信1第二段</>', 0,
      6, 1, '2019-04-02 22:33:44', 0, 0, NULL);

INSERT INTO `private_notice`
    ( `owner`, `receiver` )
VALUES
    ( 2, NULL );

INSERT INTO `comment`
    ( `author`, `mark`, `content_short`, `content`, `type`, `status`, `target`,
     `comment_disabled`, `view_times`, `img_uri` )
VALUES
    ( 3, NULL, NULL, '评论1', 2, 0, 1, 0, 10, NULL );