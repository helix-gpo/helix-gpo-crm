-- insert projects values
insert into projects (id, title, description, start_date, end_date, creation_date, last_update, status, price, image_url, content_type, show_on_website, partner_id)
values (1, 'CRM-System Einführung', 'Einführung eines CRM-Systems zur besseren Kundenpflege.', '2024-01-10', '2024-06-30', '2024-01-05', '2024-06-15', 'PLANNED', 75000.00, '1.png', 'image/png', true, 1);
insert into projects (id, title, description, start_date, end_date, creation_date, last_update, status, price, image_url, content_type, show_on_website, partner_id)
values (2, 'Monitoring Dashboard', 'Echtzeit-Dashboard für Produktionsanlagen.', '2024-03-01', '2024-11-30', '2024-02-20', '2024-08-10', 'ACTIVE', 50000.00, '2.png', 'image/png', true, 1);
insert into projects (id, title, description, start_date, end_date, creation_date, last_update, status, price, image_url, content_type, show_on_website, partner_id)
values (3, 'Prozessstrategie 2030', 'Strategische Beratung zur Optimierung interner Prozesse.', '2024-05-15', '2025-05-15', '2024-05-01', '2025-01-10', 'ON_HOLD', 120000.00, '3.png', 'image/png', true, 2);
insert into projects (id, title, description, start_date, end_date, creation_date, last_update, status, price, image_url, content_type, show_on_website, partner_id)
values (4, 'IoT-Datenplattform', 'Zentrale Plattform zur Verarbeitung von IoT-Sensordaten.', '2024-04-01', '2024-12-20', '2024-03-20', '2024-07-15', 'REVIEW', 98000.00, '4.png', 'image/png', true, 2);
insert into projects (id, title, description, start_date, end_date, creation_date, last_update, status, price, image_url, content_type, show_on_website, partner_id)
values (5, 'Digital Twin Entwicklung', 'Virtuelles Abbild von Produktionsanlagen zur Optimierung.', '2024-06-01', '2025-02-28', '2024-05-15', '2025-01-20', 'APPROVED', 135000.00, '5.png', 'image/png', true, 3);
insert into projects (id, title, description, start_date, end_date, creation_date, last_update, status, price, image_url, content_type, show_on_website, partner_id)
values (6, 'Mobile Service App', 'Mobile Anwendung für Servicetechniker mit Offline-Modus.', '2024-08-01', '2025-04-30', '2024-07-15', '2025-02-01', 'CANCELED', 65000.00, '6.png', 'image/png', true, 4);
insert into projects (id, title, description, start_date, end_date, creation_date, last_update, status, price, image_url, content_type, show_on_website, partner_id)
values (7, 'Supply Chain Analyse', 'Optimierung der globalen Lieferketten durch Datenanalyse.', '2024-09-01', '2025-09-01', '2024-08-10', '2024-06-15', 'ACTIVE', 150000.00, '7.png', 'image/png', true, 5);

-- insert milestones values
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (1, 'Bedarfserhebung', 'Workshops und Analyse der Kundenprozesse.', '2024-01-10', '2024-02-15', 'PLANNED', 15000.00, 1);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (2, 'Systemeinführung', 'Implementierung und Schulung.', '2024-03-01', '2024-06-30', 'IN_PROGRESS', 60000.00, 1);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (3, 'Monitoring Konzept', 'Entwurf des Monitoring-Systems.', '2024-03-01', '2024-05-15', 'IN_PROGRESS', 20000.00, 2);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (4, 'Dashboard Entwicklung', 'Frontend- und Backend-Entwicklung.', '2024-05-16', '2024-11-30', 'PLANNED', 30000.00, 2);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (5, 'Strategie-Workshops', 'Workshops mit Führungskräften.', '2024-05-15', '2024-08-31', 'REVIEW', 50000.00, 3);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (6, 'Implementierungsphase', 'Umsetzung der Strategie.', '2024-09-01', '2025-05-15', 'APPROVED', 70000.00, 3);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (7, 'IoT Plattform Architektur', 'Systemdesign und Architekturplanung.', '2024-04-01', '2024-05-15', 'CANCELED', 35000.00, 4);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (8, 'IoT Integration', 'Anbindung erster Sensoren.', '2024-06-01', '2024-12-20', 'IN_PROGRESS', 63000.00, 4);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (9, 'Proof of Concept', 'Pilotierung eines Digital Twin.', '2024-06-01', '2024-08-30', 'COMPLETED', 40000.00, 5);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (10, 'Service App MVP', 'Minimal funktionsfähige Version.', '2024-08-01', '2024-11-30', 'IN_PROGRESS', 25000.00, 6);
insert into milestones (id, title, description, start_date, end_date, status, price, project_id)
values (11, 'Lieferkettenanalyse Phase 1', 'Erhebung der bestehenden Prozesse.', '2024-09-01', '2025-01-15', 'REVIEW', 60000.00, 7);

-- insert project-tag values
insert into project_tags (project_id, tag)
values (1, 'SOFTWARE');
insert into project_tags (project_id, tag)
values (1, 'PROCESS');
insert into project_tags (project_id, tag)
values (1, 'STRATEGY');

insert into project_tags (project_id, tag)
values (2, 'MONITORING');
insert into project_tags (project_id, tag)
values (2, 'SOFTWARE');

insert into project_tags (project_id, tag)
values (3, 'STRATEGY');
insert into project_tags (project_id, tag)
values (3, 'PROCESS');

insert into project_tags (project_id, tag)
values (4, 'SOFTWARE');
insert into project_tags (project_id, tag)
values (4, 'MONITORING');
insert into project_tags (project_id, tag)
values (4, 'STRATEGY');

insert into project_tags (project_id, tag)
values (5, 'PROCESS');
insert into project_tags (project_id, tag)
values (5, 'MONITORING');

insert into project_tags (project_id, tag)
values (6, 'SOFTWARE');
insert into project_tags (project_id, tag)
values (6, 'PROCESS');
insert into project_tags (project_id, tag)
values (6, 'STRATEGY');

insert into project_tags (project_id, tag)
values (7, 'STRATEGY');
insert into project_tags (project_id, tag)
values (7, 'PROCESS');
