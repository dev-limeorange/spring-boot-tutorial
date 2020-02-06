-- classpath에 위치할 경우 어플리케이션 시작 시 자동실행(DDL), DML의 경우 data.sql이라고 저장
DROP TABLE IF EXISTS book;

CREATE TABLE book (
    id VARCHAR(250),
    name VARCHAR(250) NOT NULL,
    category VARCHAR(250) NOT NULL,
    sell_count BIGINT NOT NULL,
    create_at TIMESTAMP NOT NULL,

    PRIMARY KEY (id)
);
