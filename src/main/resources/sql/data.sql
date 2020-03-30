INSERT INTO classifications (id, name) VALUES (nextval('classifications_sequence'), '�������');
INSERT INTO classifications (id, name) VALUES (nextval('classifications_sequence'), '������� ����');
INSERT INTO classifications (id, name) VALUES (nextval('classifications_sequence'), '���');;

INSERT INTO psr_states (id, name) VALUES (nextval('psr_states_sequence'), '���������');
INSERT INTO psr_states (id, name) VALUES (nextval('psr_states_sequence'), '���� �����');

INSERT INTO psr (id, name, start_date, end_date, state_id, comment)
    VALUES (nextval('psr_sequence'), '�. ������, ������ ���� ��������, ��. �������, 1965 �.�.',
            '2020-03-01', '2020-03-02', 2, '������ ���');

INSERT INTO users (id, login, password, fio) VALUES (nextval('users_sequence'), 'artem', 'password', '����� �������');
INSERT INTO users (id, login, password, fio) VALUES (nextval('users_sequence'), 'albina', 'password', '������� �������');

INSERT INTO psr_data (id, psr_id, station, rpsr, registrator, object_info, content, photo)
    VALUES (nextval('psr_data_sequence'), 1, '�. ������, ��. �������, 54� (�������) [55.835608, 49.141352]', 1, 2,
            '������ �/82, � 8:00, ������ 112, �. ������, ��. �������', '���������� �� ������� ��� ������', NULL);

INSERT INTO shuttles (id, psr_id, auto) VALUES (nextval('shuttles_sequence'), 1, 'Chevrolet Niva �123�� 116');

INSERT INTO volunteer_status (id, name) VALUES (nextval('volunteer_status_sequence'), '��������������� � �������');
INSERT INTO volunteer_status (id, name) VALUES (nextval('volunteer_status_sequence'), '�����');
INSERT INTO volunteer_status (id, name) VALUES (nextval('volunteer_status_sequence'), '������');
INSERT INTO volunteer_status (id, name) VALUES (nextval('volunteer_status_sequence'), '������ ���������');
INSERT INTO volunteer_status (id, name) VALUES (nextval('volunteer_status_sequence'), '������ � ������');
INSERT INTO volunteer_status (id, name) VALUES (nextval('volunteer_status_sequence'), '�����');
INSERT INTO volunteer_status (id, name) VALUES (nextval('volunteer_status_sequence'), '����');

INSERT INTO volunteers (id, fio, sex, phone, login_telegram, class_id, equipment, psr_list_desc, comment)
    VALUES (nextval('volunteers_sequence'), '�������� ����� ����������', false, '89033323322',
            'elena_byd_zdorov', 2, '�������', NULL, NULL);
INSERT INTO volunteers (id, fio, sex, phone, login_telegram, class_id, equipment, psr_list_desc, comment)
    VALUES (nextval('volunteers_sequence'), '����������� ���� �������', true, '89172123123',
            'iluha_voluteer', 3, '���������', NULL, NULL);
INSERT INTO volunteers (id, fio, sex, phone, login_telegram, class_id, equipment, psr_list_desc, comment)
    VALUES (nextval('volunteers_sequence'), '������ ���� ��������', true, '89178325478', 'ti_ne_odin', 1,
            '�����, ������', NULL, NULL);

INSERT INTO shuttle_data (id, shuttle_id, vol_id, is_driver) VALUES (nextval('shuttle_data_sequence'), 1, 1, true);
INSERT INTO shuttle_data (id, shuttle_id, vol_id, is_driver) VALUES (nextval('shuttle_data_sequence'), 1, 2, false);