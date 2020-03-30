INSERT INTO classifications (id, name) VALUES (nextval('classifications_sequence'), 'Новичек');
INSERT INTO classifications (id, name) VALUES (nextval('classifications_sequence'), 'Средний опыт');
INSERT INTO classifications (id, name) VALUES (nextval('classifications_sequence'), 'СПГ');;

INSERT INTO psr_states (id, name) VALUES (nextval('psr_states_sequence'), 'Завершена');
INSERT INTO psr_states (id, name) VALUES (nextval('psr_states_sequence'), 'Идет поиск');

INSERT INTO psr (id, name, start_date, end_date, state_id, comment)
    VALUES (nextval('psr_sequence'), 'г. Казань, Иванов Иван Иванович, ул. Чуйкова, 1965 г.р.',
            '2020-03-01', '2020-03-02', 2, 'Найден Жив');

INSERT INTO users (id, login, password, fio) VALUES (nextval('users_sequence'), 'artem', 'password', 'Артем Латышев');
INSERT INTO users (id, login, password, fio) VALUES (nextval('users_sequence'), 'albina', 'password', 'Альбина Гараева');

INSERT INTO psr_data (id, psr_id, station, rpsr, registrator, object_info, content, photo)
    VALUES (nextval('psr_data_sequence'), 1, 'г. Казань, ул. Чуйкова, 54а (Стоянка) [55.835608, 49.141352]', 1, 2,
            'Пропал М/82, в 8:00, заявка 112, г. Казань, ул. Чуйкова', 'Инфомрация по второму дню поиска', NULL);

INSERT INTO shuttles (id, psr_id, auto) VALUES (nextval('shuttles_sequence'), 1, 'Chevrolet Niva п123ср 116');

INSERT INTO volunteer_status (id, name) VALUES (nextval('volunteer_status_sequence'), 'Зарегестрирован в системе');
INSERT INTO volunteer_status (id, name) VALUES (nextval('volunteer_status_sequence'), 'Выезд');
INSERT INTO volunteer_status (id, name) VALUES (nextval('volunteer_status_sequence'), 'Прибыл');
INSERT INTO volunteer_status (id, name) VALUES (nextval('volunteer_status_sequence'), 'Задача выполнена');
INSERT INTO volunteer_status (id, name) VALUES (nextval('volunteer_status_sequence'), 'Задача в работе');
INSERT INTO volunteer_status (id, name) VALUES (nextval('volunteer_status_sequence'), 'Домой');
INSERT INTO volunteer_status (id, name) VALUES (nextval('volunteer_status_sequence'), 'Дома');

INSERT INTO volunteers (id, fio, sex, phone, login_telegram, class_id, equipment, psr_list_desc, comment)
    VALUES (nextval('volunteers_sequence'), 'Малышева Елена Васильевна', false, '89033323322',
            'elena_byd_zdorov', 2, 'аптечка', NULL, NULL);
INSERT INTO volunteers (id, fio, sex, phone, login_telegram, class_id, equipment, psr_list_desc, comment)
    VALUES (nextval('volunteers_sequence'), 'Доровольцев Илья Муромец', true, '89172123123',
            'iluha_voluteer', 3, 'навигатор', NULL, NULL);
INSERT INTO volunteers (id, fio, sex, phone, login_telegram, class_id, equipment, psr_list_desc, comment)
    VALUES (nextval('volunteers_sequence'), 'Иванов Иван Иванович', true, '89178325478', 'ti_ne_odin', 1,
            'рация, гитара', NULL, NULL);

INSERT INTO shuttle_data (id, shuttle_id, vol_id, is_driver) VALUES (nextval('shuttle_data_sequence'), 1, 1, true);
INSERT INTO shuttle_data (id, shuttle_id, vol_id, is_driver) VALUES (nextval('shuttle_data_sequence'), 1, 2, false);