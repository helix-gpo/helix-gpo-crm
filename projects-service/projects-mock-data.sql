-- insert projects values
insert into projects (id, title, description, start_date, end_date, creation_date, last_update, status, price, image_url, content_type, show_on_website, partner_id)
values (1, 'CRM Optimierung', 'Implementierung eines modernen CRM-Systems zur Kundenbindung.', '2024-01-10', '2024-06-30', '2024-01-05', '2024-06-15', 'APPROVED', 68000.00, '1.png', 'image/png', true, 1);
insert into projects (id, title, description, start_date, end_date, creation_date, last_update, status, price, image_url, content_type, show_on_website, partner_id)
values (2, 'Analytics Dashboard', 'Entwicklung eines Echtzeit-Dashboards zur Produktionsüberwachung.', '2024-03-01', '2024-11-30', '2024-02-20', '2024-08-10', 'ACTIVE', 52000.00, '2.png', 'image/png', true, 2);
insert into projects (id, title, description, start_date, end_date, creation_date, last_update, status, price, image_url, content_type, show_on_website, partner_id)
values (3, 'Business Process Redesign', 'Strategische Neuausrichtung der Geschäftsprozesse.', '2024-05-15', '2025-05-15', '2024-05-01', '2025-01-10', 'PLANNED', 118000.00, '3.png', 'image/png', true, 3);
insert into projects (id, title, description, start_date, end_date, creation_date, last_update, status, price, image_url, content_type, show_on_website, partner_id)
values (4, 'IoT Data Hub', 'Aufbau einer zentralen Plattform zur Integration von Sensordaten.', '2024-04-01', '2024-12-20', '2024-03-20', '2024-07-15', 'ON_HOLD', 95000.00, '4.png', 'image/png', true, 4);
insert into projects (id, title, description, start_date, end_date, creation_date, last_update, status, price, image_url, content_type, show_on_website, partner_id)
values (5, 'Predictive Maintenance Suite', 'Entwicklung eines Analyse-Tools zur vorausschauenden Wartung.', '2024-06-01', '2025-02-28', '2024-05-15', '2025-01-20', 'REVIEW', 132000.00, '5.png', 'image/png', true, 5);

-- insert milestones values
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (1, 'Anforderungsanalyse', 'Workshops und Bedarfsermittlung mit dem Kunden.', '2024-01-10', '2024-02-15', 'APPROVED', 12000.00, 1);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (2, 'Systemeinführung', 'Implementierung und Schulung der Mitarbeiter.', '2024-03-01', '2024-06-30', 'REVIEW', 56000.00, 1);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (3, 'Konzeptphase', 'Definition der Architektur des Dashboards.', '2024-03-01', '2024-05-15', 'IN_PROGRESS', 20000.00, 2);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (4, 'Entwicklungsphase', 'Frontend- und Backend-Implementierung.', '2024-05-16', '2024-11-30', 'PLANNED', 32000.00, 2);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (5, 'Strategie-Workshops', 'Prozessanalyse mit dem Management-Team.', '2024-05-15', '2024-08-31', 'PLANNED', 48000.00, 3);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (6, 'Umsetzungsphase', 'Einführung optimierter Workflows.', '2024-09-01', '2025-05-15', 'PLANNED', 70000.00, 3);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (7, 'Systemdesign', 'Architekturplanung und Sicherheitskonzept.', '2024-04-01', '2024-05-15', 'IN_PROGRESS', 35000.00, 4);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (8, 'Integration', 'Verbindung der ersten IoT-Geräte.', '2024-06-01', '2024-12-20', 'PLANNED', 60000.00, 4);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (9, 'Pilotphase', 'Testbetrieb der Predictive Maintenance Lösung.', '2024-06-01', '2024-08-30', 'IN_PROGRESS', 42000.00, 5);

-- insert project-tag values (SOFTWARE, PROCESS, STRATEGY, MONITORING)
insert into project_tags (project_id, tag) values (1, 'STRATEGY');
insert into project_tags (project_id, tag) values (1, 'SOFTWARE');
insert into project_tags (project_id, tag) values (2, 'SOFTWARE');
insert into project_tags (project_id, tag) values (2, 'MONITORING');
insert into project_tags (project_id, tag) values (3, 'STRATEGY');
insert into project_tags (project_id, tag) values (3, 'PROCESS');
insert into project_tags (project_id, tag) values (4, 'MONITORING');
insert into project_tags (project_id, tag) values (4, 'SOFTWARE');
insert into project_tags (project_id, tag) values (5, 'MONITORING');
insert into project_tags (project_id, tag) values (5, 'SOFTWARE');
