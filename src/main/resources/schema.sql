CREATE TABLE IF NOT EXISTS citizenship
(
    id      INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
    name    VARCHAR(50) NOT NULL COMMENT 'Страна',
    code    VARCHAR(50) NOT NULL COMMENT 'Код страны',
    version INTEGER     NOT NULL COMMENT 'Служебное поле Hibernate'
);
COMMENT ON TABLE citizenship IS 'Таблица стран';

CREATE TABLE IF NOT EXISTS users
(
    id             INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
    first_name     VARCHAR(50) NOT NULL COMMENT 'Имя',
    second_name    VARCHAR(50) COMMENT 'Фамилия',
    middle_name    VARCHAR(50) COMMENT 'Отчество',
    position       VARCHAR(50) NOT NULL COMMENT 'Должность',
    phone          VARCHAR(50) COMMENT 'Телефон',
    citizenship_id INTEGER COMMENT 'Поле, связывающая работника с его гражданством',
    FOREIGN KEY (citizenship_id) REFERENCES citizenship (id),
    is_identified  BOOLEAN COMMENT 'Идентификация',
    version        INTEGER     NOT NULL COMMENT 'Служебное поле Hibernate'
);
COMMENT ON TABLE users IS 'Таблица работников';

CREATE TABLE IF NOT EXISTS type_document
(
    id      INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
    type    VARCHAR(50) NOT NULL COMMENT 'Тип документа',
    code    VARCHAR(20)  NOT NULL COMMENT 'Код документа',
    version INTEGER     NOT NULL COMMENT 'Служебное поле Hibernate'
);
COMMENT ON TABLE type_document IS 'Таблица типов документов';



CREATE TABLE IF NOT EXISTS document_user
(
    id         INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
    user_doc_id INTEGER COMMENT 'Связь документа с работником',
    FOREIGN KEY (user_doc_id) REFERENCES users (id),
    number     INTEGER COMMENT 'Номер документа работника',
    date       VARCHAR(20) COMMENT 'Дата выдачи документа работника',
    type_id    INTEGER COMMENT 'Идентификатор, связывающий документ с типом документа',
    FOREIGN KEY (type_id) REFERENCES type_document (id),
    version    INTEGER NOT NULL COMMENT 'Служебное поле Hibernate'
);
COMMENT ON TABLE document_user IS 'Таблица документов';


CREATE TABLE IF NOT EXISTS organization
(
    id        INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
    name      VARCHAR(50) NOT NULL COMMENT 'Имя организации',
    full_name VARCHAR(50) NOT NULL COMMENT 'Полное имя организации',
    inn       INTEGER     NOT NULL,
    kpp       INTEGER     NOT NULL,
    address   VARCHAR(50) NOT NULL COMMENT 'Адрес организации',
    phone     VARCHAR(50) COMMENT 'Телефон организации',
    is_active BOOLEAN,
    version   INTEGER     NOT NULL COMMENT 'Служебное поле Hibernate'

);
COMMENT ON TABLE organization IS 'Таблица организаций';

CREATE TABLE IF NOT EXISTS office
(
    id        INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
    org_id    INTEGER COMMENT 'Идентификатор связанный с идентификатором (id) в таблице организаций',
    FOREIGN KEY (org_id) REFERENCES organization (id),
    name      VARCHAR(50) NOT NULL COMMENT 'Название офиса',
    address   VARCHAR(50) NOT NULL COMMENT 'Адрес офиса',
    phone     VARCHAR(50) COMMENT 'Телефонный номер офиса',
    is_active BOOLEAN,
    version   INTEGER     NOT NULL COMMENT 'Служебное поле Hibernate'

);
COMMENT ON TABLE office IS 'Таблица офисов';

CREATE TABLE IF NOT EXISTS office_user
(
    office_id INTEGER COMMENT 'Идентификатор офиса',
    user_id   INTEGER COMMENT 'Идентификатор работника',

    PRIMARY KEY (office_id, user_id),

    FOREIGN KEY (office_id) REFERENCES Office (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE INDEX IX_user_first_name ON users (first_name);
CREATE INDEX IX_user_second_name ON users (second_name);
CREATE INDEX IX_user_middle_name ON users (middle_name);
CREATE INDEX IX_user_position ON users (position);
CREATE INDEX IX_user_citizenship_id ON users (citizenship_id);

CREATE INDEX IX_country ON citizenship (name);
CREATE INDEX IX_country_code ON citizenship (code);

CREATE INDEX IX_doc_type ON type_document (type);
CREATE INDEX IX_doc_type_code ON type_document (code);


CREATE UNIQUE INDEX UX_doc_user_doc_id ON document_user (user_doc_id);
CREATE UNIQUE INDEX UX_doc_user_doc_number ON document_user (number);
CREATE INDEX IX_doc_user_doc_date ON document_user (date);
CREATE INDEX IX_doc_user_type_id ON document_user (type_id);


CREATE UNIQUE INDEX UX_organization_full_name ON organization (full_name);
CREATE UNIQUE INDEX UX_organization_inn  ON organization (inn);
CREATE UNIQUE INDEX UX_organization_kpp  ON organization (kpp);

CREATE INDEX IX_office_name ON office (name);
CREATE INDEX IX_office_Org_Id ON office (org_id);

CREATE INDEX IX_Employee_Office_Id ON office_user(office_id);
CREATE INDEX IX_Office_Employee_Id ON office_user (user_id);

