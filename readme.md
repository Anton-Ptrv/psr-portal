### Уточнения и необходимы исправленя модели данных:

#### Уточнения
1) Таблица volonteers
* Что такое class_id? (внешний ключ? на что?)
* Что такое psr_list_desc? (Если описание, то почему оно здесь?)
* Что такое remm? (сокращение от remark?)
* Пример equipment?
2) Таблица psr_list_registration
* Что такое psr_list_id (внешний ключ? на что?)
* Статус чего status? (почему число?)
* Что такое class_id? (внешний ключ? на что?)
* Что такое rvp? (почему только время?)
* Что такое rvo? (почему только время?)
3) Таблица psr_data
* Что такое psr_list_id (внешний ключ? на что?)
* Что такое station? (станция? местоположение? база? кого и чего?)
* Что такое rpsr?
* Что такое registrator? (integer?)
* Что будет хранится в object_info?
* Что будет хранится в content? 
* Фото кого? foto? (переименовать)
4) Таблица list_vol_states
* А где сами состояния/статусы? 
* Почему везде поле fio, а тут name? 
* Почему list?
5) list_users
* Где поле id-шника/pk? 
* Почему login не not null?
* Почему password не not null?
* Где constraint на уникальность? 
6) list_psr
* Что означает code? (Код чего?)
* Что означает name? (Кодовое название пср? Имя человека кого ищут? Имя ответственного за пср?)
* Что означает end_date? (Дата когда искать перестали? Или когда нашли?)
* Что означает state? (Состояние поиска? Почему integer?)
* Что означает remm? 
7) list_class
* Что такое remm? (сокращение от remark?)
* name - классификация добровольца? 

#### Необходимые исправления
##### Переименования
1) Таблица volonteers в volunteers
2) psr_list_registration.is_auto в psr_list_registration.has_auto
3) psr_list_registration.shuttle_num в psr_list_registration.vehicle_registration_plate
4) psr_data.registrator в что-то ...
5) psr_data.foto в psr_data.photo
6) list_vol_states в volunteer_status
7) list_users в user

##### Типы данных
1) volonteers.rvp time в timestamp (дата + время)
2) volonteers.rvo time в timestamp (дата + время)
3) Заменить на полях "описания" character(x) на varchar
* volonteers.equipment
* volonteers.psr_list_desc
* volonteers.remm
* psr_data.station
* psr_data.rpsr
* psr_data.object_info
* psr_data.content
* list_psr.code?
* list_psr.remm
* list_class.remm

#### Предложения
1) Уточнения по количеству посадочных мест в машине

#### Вопросы
1) Волонтеры имеют доступ к порталу?
2) Ролевая модель нужна?
3) Кто есть кроме волонтеров? 