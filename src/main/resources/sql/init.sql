CREATE TABLE user
(
    seq              bigint AUTO_INCREMENT
        PRIMARY KEY,
    id               varchar(200)            NOT NULL COMMENT '아이디',
    password         varchar(128)            NOT NULL COMMENT '비밀번호',
    email            varchar(128) DEFAULT '' NOT NULL COMMENT 'email',
    name             varchar(128) DEFAULT '' NOT NULL COMMENT '이름',
    phone_number     varchar(20)  DEFAULT '' NOT NULL COMMENT '전화번호',
    birth            varchar(8)  DEFAULT '' NOT NULL COMMENT '생년월일',
    created_at       datetime(6)             NOT NULL COMMENT '등록 일시'
)
    COMMENT '유저';
