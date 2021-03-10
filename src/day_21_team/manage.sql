CREATE TABLE manage(
  serial NUMBER,
  name VARCHAR2(20),
  department VARCHAR2(20),
  position VARCHAR2(20),
  year NUMBER,
  PRIMARY KEY (serial)
);

CREATE TABLE product(
  serial NUMBER,
  name VARCHAR2(20),
  count NUMBER,
  PRIMARY KEY (serial)
);

CREATE TABLE event(
  day VARCHAR2(20),
  name VARCHAR2(20),
  person VARCHAR2(20),
  content VARCHAR2(20),
  PRIMARY KEY (day)
);