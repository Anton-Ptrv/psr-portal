### Уточнения и необходимы исправленя модели данных:

#### Уточнения
1) volonteers
* Что такое class_id? (внешний ключ? на что?)
* Что такое psr_list_desc? (Если описание, то почему оно здесь?)
* Что такое remm? (сокращение от remark?)
* Пример equipment?
2) psr_list_registration
* Что такое psr_list_id (внешний ключ? на что?)
* Статус чего status?
* Что такое class_id? (внешний ключ? на что?)
* Что такое rvp?
* Что такое rvo?

#### Исправления
##### Переименования
1) volonteers в volunteers
2) is_auto в has_auto

##### Типы данных
1) rvp time в timestamp (дата + время)
2) rvo time в timestamp (дата + время)
3) Заменить на полях описания character(300) на varchar
* volonteers.equipment
* volonteers.psr_list_desc
* volonteers.remm
