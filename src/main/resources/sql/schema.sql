-- DROP TABLES
DROP TABLE IF EXISTS psr_data;
DROP TABLE IF EXISTS psr_list_registration;
DROP TABLE IF EXISTS shuttle_data;
DROP TABLE IF EXISTS volunteers;
DROP TABLE IF EXISTS shuttles;
DROP TABLE IF EXISTS psr;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS volunteer_status;
DROP TABLE IF EXISTS classifications;
DROP TABLE IF EXISTS psr_states;

-- Table: classifications
CREATE TABLE classifications
(
    id   integer NOT NULL,
    name character varying(100), -- Наименоваие
    CONSTRAINT list_class_pk PRIMARY KEY (id)
) WITH (OIDS= FALSE);

ALTER TABLE classifications
    OWNER TO postgres;

COMMENT ON TABLE classifications
    IS 'Классификации - призгак по которому разделять добровольцев.
Название кваливикации: местный, мчс, ЛА.
Может быть любой по желанию заказчика.';
COMMENT ON COLUMN classifications.name IS 'Наименоваие';

CREATE INDEX classifications_id_idx ON classifications USING btree (id);

-- Table: volunteer_status
CREATE TABLE volunteer_status
(
    id   integer NOT NULL,       -- ID статуса
    name character varying(200), -- Наименование статуса добровольца
    CONSTRAINT volunteer_status_id_pk PRIMARY KEY (id)
) WITH (OIDS= FALSE);

ALTER TABLE volunteer_status
    OWNER TO postgres;

COMMENT ON TABLE volunteer_status IS 'Статусы добровольцев';
COMMENT ON COLUMN volunteer_status.id IS 'ID статуса';
COMMENT ON COLUMN volunteer_status.name IS 'Наименование статуса добровольца';

CREATE UNIQUE INDEX volunteer_status_id_idx ON volunteer_status USING btree (id);

-- Table: psr_states
CREATE TABLE psr_states
(
    id   integer NOT NULL,
    name character varying(50), -- Наименование статуса
    CONSTRAINT psr_states_pk PRIMARY KEY (id)
) WITH (OIDS= FALSE);

ALTER TABLE psr_states
    OWNER TO postgres;

COMMENT ON TABLE psr_states IS 'Статусы ПСР';
COMMENT ON COLUMN psr_states.name IS 'Наименование статуса';

CREATE INDEX psr_states_id_idx ON psr_states USING btree (id);

-- Table: psr
CREATE TABLE psr
(
    id         integer           NOT NULL,
    name       character varying NOT NULL, -- Наименование. Состоит из Адреса + ФИО потерявшегося.
    start_date date              NOT NULL, -- Дата начала ПСР
    end_date   date,                       -- Дата окончания ПСР
    state_id   integer           NOT NULL, -- Статус(выбирается из спр-ка)
    comment    character varying,          -- Примечание
    CONSTRAINT psr_pk PRIMARY KEY (id),
    CONSTRAINT psr_states_fk FOREIGN KEY (state_id)
        REFERENCES psr_states (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH (OIDS= FALSE);

ALTER TABLE psr
    OWNER TO postgres;

COMMENT ON TABLE psr IS 'Перечень ПСР';
COMMENT ON COLUMN psr.name IS 'Наименование. Состоит из Адреса + ФИО потерявшегося.';
COMMENT ON COLUMN psr.start_date IS 'Дата начала ПСР';
COMMENT ON COLUMN psr.end_date IS 'Дата окончания ПСР';
COMMENT ON COLUMN psr.state_id IS 'Статус(выбирается из спр-ка)';
COMMENT ON COLUMN psr.comment IS 'Примечание';

CREATE INDEX psr_id_idx ON psr USING btree (id);
CREATE INDEX psr_state_idx ON psr USING btree (state_id);

-- Table: shuttles
CREATE TABLE shuttles
(
    id     integer NOT NULL,
    psr_id integer,                -- ПСР
    auto   character varying(100), -- Марка и номер машины
    CONSTRAINT shuttles_id_pk PRIMARY KEY (id),
    CONSTRAINT psr_fk FOREIGN KEY (psr_id)
        REFERENCES psr (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH (OIDS= FALSE);

ALTER TABLE shuttles
    OWNER TO postgres;

COMMENT ON TABLE shuttles IS 'Зарегестрированные на ПСР экипажи ';
COMMENT ON COLUMN shuttles.psr_id IS 'ПСР';
COMMENT ON COLUMN shuttles.auto IS 'Марка и номер машины';

CREATE INDEX shuttles_id_idx ON shuttles USING btree (id);
CREATE INDEX shuttles_psr_id_idx ON shuttles USING btree (psr_id);

-- Table: users
CREATE TABLE users
(
    id       numeric NOT NULL,
    login    character varying(50), -- Логин
    password character varying(20), -- Пароль
    fio      character varying(100),
    CONSTRAINT users_id_pk PRIMARY KEY (id),
    CONSTRAINT users_login_uk UNIQUE (login)
) WITH (OIDS= FALSE);

ALTER TABLE users
    OWNER TO postgres;

COMMENT ON TABLE users IS 'Список пользователей';
COMMENT ON COLUMN users.login IS 'Логин';
COMMENT ON COLUMN users.password IS 'Пароль';

CREATE UNIQUE INDEX users_id_idx ON users USING btree (id);
CREATE UNIQUE INDEX users_login_idx ON users USING btree (login COLLATE pg_catalog."default");

-- Table: volunteers
CREATE TABLE volunteers
(
    id             integer                NOT NULL,
    fio            character varying(100) NOT NULL, -- ФИО
    sex            boolean                NOT NULL, -- Пол
    phone          character varying(20)  NOT NULL, -- Номер телефона
    login_telegram character varying(32)  NOT NULL, -- Логин телеграмм
    class_id       integer,                         -- Классификация
    equipment      character varying(500),          -- Список оборудования
    psr_list_desc  character varying,               -- Список работ в которых принимал участие
    comment        character varying,               -- Примечание
    CONSTRAINT volunteers_id_pk PRIMARY KEY (id),
    CONSTRAINT classifications_fk FOREIGN KEY (class_id)
        REFERENCES classifications (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT volunteer_login_uk UNIQUE (login_telegram),
    CONSTRAINT volunteer_phone_uk UNIQUE (phone)
) WITH (OIDS= FALSE);

ALTER TABLE volunteers
    OWNER TO postgres;

COMMENT ON TABLE volunteers IS 'Справочник Добровольцы';
COMMENT ON COLUMN volunteers.fio IS 'ФИО';
COMMENT ON COLUMN volunteers.sex IS 'Пол';
COMMENT ON COLUMN volunteers.phone IS 'Номер телефона';
COMMENT ON COLUMN volunteers.login_telegram IS 'Логин телеграмм';
COMMENT ON COLUMN volunteers.class_id IS 'Классификация';
COMMENT ON COLUMN volunteers.equipment IS 'Список оборудования';
COMMENT ON COLUMN volunteers.psr_list_desc IS 'Список работ в которых принимал участие';
COMMENT ON COLUMN volunteers.comment IS 'Примечание';

CREATE UNIQUE INDEX volunteers_id_idx ON volunteers USING btree (id);
CREATE UNIQUE INDEX volunteers_login_uidx ON volunteers USING btree (login_telegram COLLATE pg_catalog."default");
CREATE UNIQUE INDEX volunteers_phone_uidx ON volunteers USING btree (phone COLLATE pg_catalog."default");

-- Table: psr_data
CREATE TABLE psr_data
(
    id          integer NOT NULL,
    psr_id      integer,                -- ПСР
    station     character varying(500), -- Адрес штаба
    rpsr        integer,                -- Руководитель ПСР (из спр-ка Пользователи)
    registrator integer,                -- Регистратор ПСР (из спр-ка Пользователи)
    object_info character varying,      -- Первичная информация о поиске
    content     character varying,      -- Основная информация о поиске
    photo       bytea[],                -- Ориентировка или фотография ОП(объекта поиска)
    CONSTRAINT psr_data_pk PRIMARY KEY (id),
    CONSTRAINT psr_fk FOREIGN KEY (psr_id)
        REFERENCES psr (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT users_fk1 FOREIGN KEY (rpsr)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT users_fk2 FOREIGN KEY (registrator)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH (OIDS= FALSE);

ALTER TABLE psr_data
    OWNER TO postgres;

COMMENT ON TABLE psr_data IS 'Данные поисково-спасательных работ';
COMMENT ON COLUMN psr_data.psr_id IS 'ПСР';
COMMENT ON COLUMN psr_data.station IS 'Адрес штаба';
COMMENT ON COLUMN psr_data.rpsr IS 'Руководитель ПСР (из спр-ка Пользователи)';
COMMENT ON COLUMN psr_data.registrator IS 'Регистратор ПСР (из спр-ка Пользователи)';
COMMENT ON COLUMN psr_data.object_info IS 'Первичная информация о поиске';
COMMENT ON COLUMN psr_data.content IS 'Основная информация о поиске';
COMMENT ON COLUMN psr_data.photo IS 'Ориентировка или фотография ОП(объекта поиска)';

CREATE INDEX psr_data_id_idx ON psr_data USING btree (id);
CREATE INDEX psr_data_psr_id_idx ON psr_data USING btree (psr_id);

-- Table: psr_list_registration
CREATE TABLE psr_list_registration
(
    id integer NOT NULL,
    psr_id integer NOT NULL,                -- ПСР (из спр-ка)
    vol_id integer NOT NULL,                -- Доброволец (из спр-ка)
    status_id integer NOT NULL,             -- Статус (ссылка на list_vol_states)
    shuttle_num integer,                    -- Номер экипажа
    departure_address character varying,    -- Адрес отправления
    rvp timestamp without time zone,        -- Расчетное время прибытия волонетра
    rvo timestamp without time zone,        -- Расчетное время отбытия волонетра
    CONSTRAINT psr_list_registration_pk PRIMARY KEY (id),
    CONSTRAINT psr_fk FOREIGN KEY (psr_id)
        REFERENCES psr (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT volunteer_fk FOREIGN KEY (vol_id)
        REFERENCES volunteers (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT volunteer_status_fk FOREIGN KEY (status_id)
        REFERENCES volunteer_status (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH (OIDS=FALSE);

ALTER TABLE psr_list_registration
    OWNER TO postgres;

COMMENT ON TABLE psr_list_registration IS 'Лист регистрации участников заявившихся на ПСР';
COMMENT ON COLUMN psr_list_registration.psr_id IS 'ПСР (из спр-ка)';
COMMENT ON COLUMN psr_list_registration.vol_id IS 'Доброволец (из спр-ка)';
COMMENT ON COLUMN psr_list_registration.status_id IS 'Статус (ссылка на list_vol_states)';
COMMENT ON COLUMN psr_list_registration.shuttle_num IS 'Номер экипажа';
COMMENT ON COLUMN psr_list_registration.departure_address IS 'Адрес отправления';
COMMENT ON COLUMN psr_list_registration.rvp IS 'Расчетное время прибытия волонетра';
COMMENT ON COLUMN psr_list_registration.rvo IS 'Расчетное время отбытия волонетра';

CREATE INDEX psr_list_registration_id_idx ON psr_list_registration USING btree(id);
CREATE INDEX psr_list_registration_psr_id_idx ON psr_list_registration USING btree(psr_id);
CREATE INDEX psr_list_registration_status_idx ON psr_list_registration USING btree(status_id);

-- Table: shuttle_data
CREATE TABLE shuttle_data
(
    id integer NOT NULL,
    shuttle_id integer NOT NULL,                -- Экипаж
    vol_id integer NOT NULL,                    -- Доброволец
    is_driver boolean NOT NULL DEFAULT false,   -- Признак "Водитель"
    CONSTRAINT shuttle_data_id_pk PRIMARY KEY (id),
    CONSTRAINT shuttles_fk FOREIGN KEY (shuttle_id)
        REFERENCES shuttles (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT volunteer_fk FOREIGN KEY (vol_id)
        REFERENCES volunteers (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH (OIDS=FALSE);

ALTER TABLE shuttle_data
    OWNER TO postgres;

COMMENT ON TABLE shuttle_data IS 'Данные о составе экипажей';
COMMENT ON COLUMN shuttle_data.shuttle_id IS 'Экипаж';
COMMENT ON COLUMN shuttle_data.vol_id IS 'Доброволец';
COMMENT ON COLUMN shuttle_data.is_driver IS 'Признак "Водитель"';

CREATE UNIQUE INDEX shuttle_data_id_idx ON shuttle_data USING btree(id);
CREATE INDEX shuttle_data_shuttle_id_idx ON shuttle_data USING btree(shuttle_id);
CREATE UNIQUE INDEX shuttle_data_vol_id_idx ON shuttle_data USING btree(vol_id);