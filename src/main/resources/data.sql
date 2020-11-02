INSERT INTO type_document (id, type, code, version) VALUES (1, 'Паспорт РФ', '10', 0);
INSERT INTO type_document (id, type, code, version) VALUES (2, 'Загранпаспорт гражданина', '20', 0);

INSERT INTO citizenship(id, name, code, version) VALUES (1, 'Российская Федерация', '643', 0);
INSERT INTO citizenship (id, name, code, version) VALUES (2, 'Беларусь', '112', 0);
INSERT INTO citizenship (id, name, code, version) VALUES (3, 'КНР', '156', 0);
INSERT INTO citizenship (id, name, code, version) VALUES (4, 'Украина', '804', 0);


INSERT INTO organization (id, name, full_name, inn, kpp, address, phone, is_active, version) VALUES (1, 'Sokol-ATS', 'Sokol', 11111111, 22222222, 'Бульвар Юности, д.2', '8-321-123-22-55', true, 0 );
INSERT INTO organization (id, name, full_name, inn, kpp, address, phone, is_active, version) VALUES (2, 'Yandex', 'Yandex.GO', 33333333, 44444444, 'Бульвар Юности, д.6', '8-915-234-32-67', false, 0 );
INSERT INTO organization (id, name, full_name, inn, kpp, address, phone, is_active, version) VALUES (3, 'Google', 'Google Inc', 55555555, 66666666, 'ул.Губкина, д.42', '8-234-456-98-65', true, 0 );

INSERT INTO office (id, org_id, name, address, phone, is_active, version) VALUES (1, 1, 'Office Sokol', 'ул.Мира, д.10', '8-925-234-12-15', true, 0 );
INSERT INTO office (id, org_id, name, address, phone, is_active, version) VALUES (2, 2, 'Office Yandex', 'ул.Дзержинского, д.21', '8-983-856-12-65', true, 0 );


INSERT INTO users (id, first_name, second_name, middle_name, position, phone, citizenship_id, is_identified, version) VALUES (1, 'Костя', 'Аркатов', 'Николаевич', 'Developer', '8-521-333-22-11', 1, true, 0 );
INSERT INTO users (id, first_name, second_name, middle_name, position, phone, citizenship_id, is_identified, version) VALUES (2, 'Шляхов', 'Кирилл', 'Алексеевич', 'Lead', '8-111-222-45-65', 1, true, 0 );
INSERT INTO users (id, first_name, second_name, middle_name, position, phone, citizenship_id, is_identified, version) VALUES (3, 'Путинцев', 'Андрей', 'Сергеевич', 'Director', '8-999-234-90-22', 2, true, 0 );


INSERT INTO office_user (office_id, user_id) VALUES (1, 1);
INSERT INTO office_user (office_id, user_id) VALUES (2, 2);
INSERT INTO office_user (office_id, user_id) VALUES (1, 3);
INSERT INTO office_user (office_id, user_id) VALUES (2, 1);



INSERT INTO document_user (id, user_doc_id, number, date, type_id, version ) VALUES (1, 1, 11111, '12-11-1994', 1, 0);
INSERT INTO document_user (id, user_doc_id, number, date, type_id, version) VALUES (2, 2, 22222, '06-11-1995', 1, 0);
INSERT INTO document_user (id, user_doc_id, number, date, type_id, version ) VALUES (3, 3, 33333, '19-09-194', 1, 0);