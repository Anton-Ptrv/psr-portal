-- DROP TABLES AND SEQUENCES
DROP TABLE IF EXISTS psr_data;
DROP SEQUENCE IF EXISTS psr_data_sequence;
DROP TABLE IF EXISTS psr_list_registration;
DROP SEQUENCE IF EXISTS psr_list_registration_sequence;
DROP TABLE IF EXISTS shuttle_data;
DROP SEQUENCE IF EXISTS shuttle_data_sequence;
DROP TABLE IF EXISTS volunteers;
DROP SEQUENCE IF EXISTS volunteers_sequence;
DROP TABLE IF EXISTS shuttles;
DROP SEQUENCE IF EXISTS shuttles_sequence;
DROP TABLE IF EXISTS psr;
DROP SEQUENCE IF EXISTS psr_sequence;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS users_sequence;
DROP TABLE IF EXISTS volunteer_status;
DROP SEQUENCE IF EXISTS volunteer_status_sequence;
DROP TABLE IF EXISTS classifications;
DROP SEQUENCE IF EXISTS classifications_sequence;
DROP TABLE IF EXISTS psr_states;
DROP SEQUENCE IF EXISTS psr_states_sequence;

-- Table: classifications
CREATE SEQUENCE classifications_sequence start 1 increment 1;

CREATE TABLE classifications
(
    id   integer NOT NULL DEFAULT nextval('classifications_sequence'),
    name character varying(100), -- �����������
    CONSTRAINT list_class_pk PRIMARY KEY (id)
) WITH (OIDS = FALSE);

ALTER TABLE classifications
    OWNER TO postgres;

COMMENT ON TABLE classifications
    IS '������������� - ������� �� �������� ��������� ������������.
�������� ������������: �������, ���, ��.
����� ���� ����� �� ������� ���������.';
COMMENT ON COLUMN classifications.name IS '�����������';

CREATE INDEX classifications_id_idx ON classifications USING btree (id);


-- Table: volunteer_status
CREATE SEQUENCE volunteer_status_sequence start 1 increment 1;
CREATE TABLE volunteer_status
(
    id   integer NOT NULL DEFAULT nextval('volunteer_status_sequence'),       -- ID �������
    name character varying(200), -- ������������ ������� �����������
    CONSTRAINT volunteer_status_id_pk PRIMARY KEY (id)
) WITH (OIDS = FALSE);

ALTER TABLE volunteer_status
    OWNER TO postgres;

COMMENT ON TABLE volunteer_status IS '������� ������������';
COMMENT ON COLUMN volunteer_status.id IS 'ID �������';
COMMENT ON COLUMN volunteer_status.name IS '������������ ������� �����������';

CREATE UNIQUE INDEX volunteer_status_id_idx ON volunteer_status USING btree (id);

-- Table: psr_states
CREATE SEQUENCE psr_states_sequence start 1 increment 1;
CREATE TABLE psr_states
(
    id   integer NOT NULL DEFAULT nextval('psr_states_sequence'),
    name character varying(50), -- ������������ �������
    CONSTRAINT psr_states_pk PRIMARY KEY (id)
) WITH (OIDS = FALSE);

ALTER TABLE psr_states
    OWNER TO postgres;

COMMENT ON TABLE psr_states IS '������� ���';
COMMENT ON COLUMN psr_states.name IS '������������ �������';

CREATE INDEX psr_states_id_idx ON psr_states USING btree (id);

-- Table: psr
CREATE SEQUENCE psr_sequence start 1 increment 1;
CREATE TABLE psr
(
    id         integer           NOT NULL DEFAULT nextval('psr_sequence'),
    name       character varying NOT NULL, -- ������������. ������� �� ������ + ��� �������������.
    start_date date              NOT NULL, -- ���� ������ ���
    end_date   date,                       -- ���� ��������� ���
    state_id   integer           NOT NULL, -- ������(���������� �� ���-��)
    comment    character varying,          -- ����������
    CONSTRAINT psr_pk PRIMARY KEY (id),
    CONSTRAINT psr_states_fk FOREIGN KEY (state_id)
        REFERENCES psr_states (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH (OIDS = FALSE);

ALTER TABLE psr
    OWNER TO postgres;

COMMENT ON TABLE psr IS '�������� ���';
COMMENT ON COLUMN psr.name IS '������������. ������� �� ������ + ��� �������������.';
COMMENT ON COLUMN psr.start_date IS '���� ������ ���';
COMMENT ON COLUMN psr.end_date IS '���� ��������� ���';
COMMENT ON COLUMN psr.state_id IS '������(���������� �� ���-��)';
COMMENT ON COLUMN psr.comment IS '����������';

CREATE INDEX psr_id_idx ON psr USING btree (id);
CREATE INDEX psr_state_idx ON psr USING btree (state_id);

-- Table: shuttles
CREATE SEQUENCE shuttles_sequence start 1 increment 1;
CREATE TABLE shuttles
(
    id     integer NOT NULL DEFAULT nextval('shuttles_sequence'),
    psr_id integer,                -- ���
    auto   character varying(100), -- ����� � ����� ������
    CONSTRAINT shuttles_id_pk PRIMARY KEY (id),
    CONSTRAINT psr_fk FOREIGN KEY (psr_id)
        REFERENCES psr (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH (OIDS = FALSE);

ALTER TABLE shuttles
    OWNER TO postgres;

COMMENT ON TABLE shuttles IS '������������������ �� ��� �������';
COMMENT ON COLUMN shuttles.psr_id IS '���';
COMMENT ON COLUMN shuttles.auto IS '����� � ����� ������';

CREATE INDEX shuttles_id_idx ON shuttles USING btree (id);
CREATE INDEX shuttles_psr_id_idx ON shuttles USING btree (psr_id);

-- Table: users
CREATE SEQUENCE users_sequence start 1 increment 1;
CREATE TABLE users
(
    id       numeric NOT NULL DEFAULT nextval('users_sequence'),
    login    character varying(50), -- �����
    password character varying(20), -- ������
    fio      character varying(100),
    CONSTRAINT users_id_pk PRIMARY KEY (id),
    CONSTRAINT users_login_uk UNIQUE (login)
) WITH (OIDS = FALSE);

ALTER TABLE users
    OWNER TO postgres;

COMMENT ON TABLE users IS '������ �������������';
COMMENT ON COLUMN users.login IS '�����';
COMMENT ON COLUMN users.password IS '������';

CREATE UNIQUE INDEX users_id_idx ON users USING btree (id);
CREATE UNIQUE INDEX users_login_idx ON users USING btree (login COLLATE pg_catalog."default");

-- Table: volunteers
CREATE SEQUENCE volunteers_sequence start 1 increment 1;
CREATE TABLE volunteers
(
    id             integer                NOT NULL DEFAULT nextval('volunteers_sequence'),
    fio            character varying(100) NOT NULL, -- ���
    sex            boolean                NOT NULL, -- ���
    phone          character varying(20)  NOT NULL, -- ����� ��������
    login_telegram character varying(32)  NOT NULL, -- ����� ���������
    class_id       integer default 1,               -- �������������
    equipment      character varying(500),          -- ������ ������������
    psr_list_desc  character varying,               -- ������ ����� � ������� �������� �������
    comment        character varying,               -- ����������
    CONSTRAINT volunteers_id_pk PRIMARY KEY (id),
    CONSTRAINT classifications_fk FOREIGN KEY (class_id)
        REFERENCES classifications (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT volunteer_login_uk UNIQUE (login_telegram),
    CONSTRAINT volunteer_phone_uk UNIQUE (phone)
) WITH (OIDS = FALSE);

ALTER TABLE volunteers
    OWNER TO postgres;

COMMENT ON TABLE volunteers IS '���������� �����������';
COMMENT ON COLUMN volunteers.fio IS '���';
COMMENT ON COLUMN volunteers.sex IS '���';
COMMENT ON COLUMN volunteers.phone IS '����� ��������';
COMMENT ON COLUMN volunteers.login_telegram IS '����� ���������';
COMMENT ON COLUMN volunteers.class_id IS '�������������';
COMMENT ON COLUMN volunteers.equipment IS '������ ������������';
COMMENT ON COLUMN volunteers.psr_list_desc IS '������ ����� � ������� �������� �������';
COMMENT ON COLUMN volunteers.comment IS '����������';

CREATE UNIQUE INDEX volunteers_id_idx ON volunteers USING btree (id);
CREATE UNIQUE INDEX volunteers_login_uidx ON volunteers USING btree (login_telegram COLLATE pg_catalog."default");
CREATE UNIQUE INDEX volunteers_phone_uidx ON volunteers USING btree (phone COLLATE pg_catalog."default");

-- Table: psr_data
CREATE SEQUENCE psr_data_sequence start 1 increment 1;
CREATE TABLE psr_data
(
    id          integer NOT NULL DEFAULT nextval('psr_data_sequence'),
    psr_id      integer,                -- ���
    station     character varying(500), -- ����� �����
    rpsr        integer,                -- ������������ ��� (�� ���-�� ������������)
    registrator integer,                -- ����������� ��� (�� ���-�� ������������)
    object_info character varying,      -- ��������� ���������� � ������
    content     character varying,      -- �������� ���������� � ������
    photo       bytea,                -- ������������ ��� ���������� ��(������� ������)
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
) WITH (OIDS = FALSE);

ALTER TABLE psr_data
    OWNER TO postgres;

COMMENT ON TABLE psr_data IS '������ ��������-������������ �����';
COMMENT ON COLUMN psr_data.psr_id IS '���';
COMMENT ON COLUMN psr_data.station IS '����� �����';
COMMENT ON COLUMN psr_data.rpsr IS '������������ ��� (�� ���-�� ������������)';
COMMENT ON COLUMN psr_data.registrator IS '����������� ��� (�� ���-�� ������������)';
COMMENT ON COLUMN psr_data.object_info IS '��������� ���������� � ������';
COMMENT ON COLUMN psr_data.content IS '�������� ���������� � ������';
COMMENT ON COLUMN psr_data.photo IS '������������ ��� ���������� ��(������� ������)';

CREATE INDEX psr_data_id_idx ON psr_data USING btree (id);
CREATE INDEX psr_data_psr_id_idx ON psr_data USING btree (psr_id);

-- Table: psr_list_registration
CREATE SEQUENCE psr_list_registration_sequence start 1 increment 1;
CREATE TABLE psr_list_registration
(
    id integer NOT NULL DEFAULT nextval('psr_list_registration_sequence'),
    psr_id integer NOT NULL,                -- ��� (�� ���-��)
    vol_id integer NOT NULL,                -- ���������� (�� ���-��)
    status_id integer NOT NULL,             -- ������ (������ �� list_vol_states)
    shuttle_num character varying(6),       -- ����� �������
    departure_address character varying,    -- ����� �����������
    rvp timestamp without time zone,        -- ��������� ����� �������� ���������
    rvo timestamp without time zone,        -- ��������� ����� ������� ���������
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

COMMENT ON TABLE psr_list_registration IS '���� ����������� ���������� ����������� �� ���';
COMMENT ON COLUMN psr_list_registration.psr_id IS '��� (�� ���-��)';
COMMENT ON COLUMN psr_list_registration.vol_id IS '���������� (�� ���-��)';
COMMENT ON COLUMN psr_list_registration.status_id IS '������ (������ �� list_vol_states)';
COMMENT ON COLUMN psr_list_registration.shuttle_num IS '����� �������';
COMMENT ON COLUMN psr_list_registration.departure_address IS '����� �����������';
COMMENT ON COLUMN psr_list_registration.rvp IS '��������� ����� �������� ���������';
COMMENT ON COLUMN psr_list_registration.rvo IS '��������� ����� ������� ���������';

CREATE INDEX psr_list_registration_id_idx ON psr_list_registration USING btree(id);
CREATE INDEX psr_list_registration_psr_id_idx ON psr_list_registration USING btree(psr_id);
CREATE INDEX psr_list_registration_status_idx ON psr_list_registration USING btree(status_id);

-- Table: shuttle_data
CREATE SEQUENCE shuttle_data_sequence start 1 increment 1;
CREATE TABLE shuttle_data
(
    id integer NOT NULL DEFAULT nextval('shuttle_data_sequence'),
    shuttle_id integer NOT NULL,                -- ������
    vol_id integer NOT NULL,                    -- ����������
    is_driver boolean NOT NULL DEFAULT false,   -- ������� "��������"
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

COMMENT ON TABLE shuttle_data IS '������ � ������� ��������';
COMMENT ON COLUMN shuttle_data.shuttle_id IS '������';
COMMENT ON COLUMN shuttle_data.vol_id IS '����������';
COMMENT ON COLUMN shuttle_data.is_driver IS '������� "��������"';

CREATE UNIQUE INDEX shuttle_data_id_idx ON shuttle_data USING btree(id);
CREATE INDEX shuttle_data_shuttle_id_idx ON shuttle_data USING btree(shuttle_id);
CREATE UNIQUE INDEX shuttle_data_vol_id_idx ON shuttle_data USING btree(vol_id);