CREATE TABLE TABLES(
TABLE_ID BIGINT NOT NULL AUTO_INCREMENT,
STATUS VARCHAR(20) NOT NULL,
CAPACITY TINYINT NOT NULL,
PRIMARY KEY (TABLE_ID)
);

CREATE TABLE RESERVATIONS(
RESERVATION_ID BIGINT NOT NULL AUTO_INCREMENT,
TABLE_ID BIGINT NOT NULL,
STATUS VARCHAR(20) NOT NULL,
CLIENT_NAME VARCHAR(255) NOT NULL,
START_TIME TIMESTAMP NOT NULL,
PERSON_NO BIGINT NOT NULL,
PRIMARY KEY (RESERVATION_ID),
FOREIGN KEY(TABLE_ID) REFERENCES TABLES(TABLE_ID)
);

