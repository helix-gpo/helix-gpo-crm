### company service
insert into companies (id, name, legal_form, tax_number, vat_id)
values (1, 'Michael Breuer Steuerberatung', 'Einzelunternehmen', 'MB-StB-Neuss-St-ID', 'MB-StB-Neuss-USt-ID');
select * from companies;

insert into partners (id, email, job, name, phone_number, company_id)
values (1, 'mb.stb.neuss@gmail.com', 'Steuerberater', 'Michael Breuer', '01604611348', 1);
select * from partners;

insert into addresses (id, address_addition, city, number, state, street, zip_code, company_id)
values (1, null, 'Neuss', '39', 'Deutschland', 'Norfer Kirchstraße', '41469', 1);
insert into addresses (id, address_addition, city, number, state, street, zip_code, company_id)
values (2, null, 'Neuss', '3', 'Deutschland', 'Vellbrüggener Straße', '41469', 1);
select * from addresses;

insert into bank_details (id, account_holder_name, bic, iban, company_id)
values (1, 'Michael Breuer Steuerberatung', 'DEUTDEDBDUE', 'DE43300700240795085000', 1);
select * from bank_details;

## todo: add auth token for project testimonial and partner validation test


### project service
insert into projects (id, creation_date, description, end_date, image_url, last_update, partner_id, price, show_on_website, start_date, status, title)
values (1, '2025-05-30', 'Contabo Server Architektur', '2025-07-31', 'https://unsplash-images/server.png', '2025-06-07', 1, 595.00, true, '2025-06-01', 'ACTIVE', 'Contabo Projekt');
insert into projects (id, creation_date, description, end_date, image_url, last_update, partner_id, price, show_on_website, start_date, status, title)
values (2, '2025-05-31', 'Spenden Applikation - GW-Stiftung', '2025-08-31', 'https://unsplash-images/server.png', '2025-06-09', 1, 5950.00, true, '2025-07-01', 'PLANNED', 'Spenden Tool');
select * from projects;

insert into milestones (id, description, end_date, price, start_date, status, title, project_id)
values (1, 'Installation Contabo Server - Aufsetzen Lexware', '2025-06-30', 357.00, '2025-06-01', 'APPROVED', 'Lexware Aufsetzen', 1);
insert into milestones (id, description, end_date, price, start_date, status, title, project_id)
values (2, 'User anlegen - Server + Lexware', '2025-07-31', 238.00, '2025-07-01', 'IN_PROGRESS', 'User anlegen', 1);
insert into milestones (id, description, end_date, price, start_date, status, title, project_id)
values (3, 'Planung Projekt Architektur', '2025-07-15', 1190.00, '2025-06-01', 'PLANNED', 'Architekturplanung', 2);
insert into milestones (id, description, end_date, price, start_date, status, title, project_id)
values (4, 'Entwicklung der Microservice Architektur', '2025-08-31', 4805.00, '2025-07-16', 'PLANNED', 'Entwicklung + Implementierung', 2);
select * from milestones;

insert into invoices (id, title, invoice_number, issue_date, due_date, total_net_amount, total_tax_amount, total_gross_amount, reason_for_payment, status, milestone_id)
values (1, 'Installation Contabo Server - Aufsetzen Lexware', 'R0001-2025', '2025-06-30', '2025-07-30', 300.00, 57.00, 357.00, 'R0001-2025', 'PAID', 1);
insert into invoices (id, title, invoice_number, issue_date, due_date, total_net_amount, total_tax_amount, total_gross_amount, reason_for_payment, status, milestone_id)
values (2, 'User anlegen - Server + Lexware', 'R0002-2025', '2025-06-30', '2025-07-30', 200.00, 38.00, 238.00, 'R0002-2025', 'PAID', 2);
insert into invoices (id, title, invoice_number, issue_date, due_date, total_net_amount, total_tax_amount, total_gross_amount, reason_for_payment, status, milestone_id)
values (3, 'Planung Projekt Architektur', 'R0003-2025', '2025-06-30', '2025-07-30', 1000.00, 190.00, 1190.00, 'R0003-2025', 'DRAFT', 3);
insert into invoices (id, title, invoice_number, issue_date, due_date, total_net_amount, total_tax_amount, total_gross_amount, reason_for_payment, status, milestone_id)
values (4, 'Entwicklung der Microservice Architektur', 'R0004-2025', '2025-06-30', '2025-07-30', 4000.00, 760.00, 4760.00, 'R0004-2025', 'DRAFT', 4);
select * from invoices;


### testimonials service
insert into testimonials (id, title, description, creation_date, last_update, show_on_website, result, image_url, project_id)
values (1, 'Contabo', 'Contabo Doku + Architektur', '2025-07-01', '2025-07-01', true, 5, 'https://www.unsplash.com/server', 1);
insert into testimonials (id, title, description, creation_date, last_update, show_on_website, result, image_url, project_id)
values (2, 'Spenden Tool', 'Spenden Tool - GW-Stiftung', '2025-07-01', '2025-07-01', true, 4, 'https://www.unsplash.com/money', 2);
select * from testimonials;

update testimonials set testimonials.show_on_website = true where id = 2;
update testimonials set testimonials.result = 4.0 where id = 2;

delete from testimonials where id < 3;
