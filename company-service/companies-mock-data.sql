-- insert company values
insert into companies (id, name, legal_form, tax_number, vat_id)
values (1, 'Helix Solutions GmbH', 'GmbH', '123/456/7890', 'DE123456789');
insert into companies (id, name, legal_form, tax_number, vat_id)
values (2, 'NextGen Consulting AG', 'AG', '987/654/3210', 'DE987654321');
insert into companies (id, name, legal_form, tax_number, vat_id)
values (3, 'Visionary Tech UG', 'UG', '112/233/4455', 'DE112233445');
insert into companies (id, name, legal_form, tax_number, vat_id)
values (4, 'Green Future AG', 'AG', '667/788/9900', 'DE667788990');
insert into companies (id, name, legal_form, tax_number, vat_id)
values (5, 'DataWave SE', 'SE', '554/433/2211', 'DE554433221');

-- insert partners values
insert into partners (id, name, email, phone_number, job, company_id)
values (1, 'Max Mustermann', 'max.mustermann@helix.de', '+49 30 1234567', 'Geschäftsführer', 1);
insert into partners (id, name, email, phone_number, job, company_id)
values (2, 'Anna Schmidt', 'anna.schmidt@nextgen.de', '+49 89 7654321', 'Senior Consultant', 2);
insert into partners (id, name, email, phone_number, job, company_id)
values (3, 'Lukas Becker', 'lukas.becker@nextgen.de', '+49 89 7654333', 'Projektleiter', 2);
insert into partners (id, name, email, phone_number, job, company_id)
values (4, 'Sophie Klein', 'sophie.klein@visionary.de', '+49 40 998877', 'Founder', 3);
insert into partners (id, name, email, phone_number, job, company_id)
values (5, 'Martin Vogel', 'martin.vogel@greenfuture.de', '+49 711 445566', 'Nachhaltigkeitsbeauftragter', 4);
insert into partners (id, name, email, phone_number, job, company_id)
values (6, 'Clara Hoffmann', 'clara.hoffmann@datawave.de', '+49 69 332211', 'CFO', 5);
insert into partners (id, name, email, phone_number, job, company_id)
values (7, 'Jonas Meyer', 'jonas.meyer@datawave.de', '+49 69 332244', 'Head of IT', 5);

-- insert into addresses
insert into addresses (id, street, number, address_addition, city, zip_code, state, company_id)
values (1, 'Innovationsweg', '12', '2. OG', 'Berlin', '10115', 'Germany', 1);
insert into addresses (id, street, number, address_addition, city, zip_code, state, company_id)
values (2, 'Beraterring', '45', null, 'München', '80331', 'Germany', 2);
insert into addresses (id, street, number, address_addition, city, zip_code, state, company_id)
values (3, 'Startup-Allee', '7a', null, 'Hamburg', '20095', 'Germany', 3);
insert into addresses (id, street, number, address_addition, city, zip_code, state, company_id)
values (4, 'Nachhaltigkeitsstraße', '88', null, 'Stuttgart', '70173', 'Germany', 4);
insert into addresses (id, street, number, address_addition, city, zip_code, state, company_id)
values (5, 'Datenring', '101', null, 'Franktfurt am Main', '60311', 'Germany', 5);

-- insert into bank-details values
insert into bank_details (id, account_holder_name, iban, bic, bank_name, country, company_id)
values (1, 'Helix Solutions GmbH', 'DE89370400440532013000', 'COBADEFFXXX', 'Commerzbank', 'DE', 1);
insert into bank_details (id, account_holder_name, iban, bic, bank_name, country, company_id)
values (2, 'NextGen Consulting AG', 'DE44500105175407324931', 'INGDDEFFXXX', 'ING', 'DE', 2);
insert into bank_details (id, account_holder_name, iban, bic, bank_name, country, company_id)
values (3, 'Visionary Tech UG', 'DE12500105170648489890', 'DEUTDEFFXXX', 'Deutsche Bank', 'DE', 3);
insert into bank_details (id, account_holder_name, iban, bic, bank_name, country, company_id)
values (4, 'Green Future AG', 'DE22500105177891011121', 'BYLADEMMXXX', 'Sparkasse', 'DE', 4);
insert into bank_details (id, account_holder_name, iban, bic, bank_name, country, company_id)
values (5, 'DataWave SE', 'DE66500105176543219876', 'PBNKDEFFXXX', 'Postbank', 'DE', 5);

-- insert into auth-token values
insert into auth_tokens (id, value, valid, used, project_id, partner_id)
values (1, 'MV8zZmRlM2YyYy01ZTc3LTRhOWItYTFjOS0yZmQ3YjFmNWEyYjc=', true,false, 1, 1);
insert into auth_tokens (id, value, valid, used, project_id, partner_id)
values (2, 'Ml8zZmRlM2YyYy01ZTc3LTRhOWItYTFjOS0yZmQ3YjFmNWEyYjc=', true,false, 2, 2);
insert into auth_tokens (id, value, valid, used, project_id, partner_id)
values (3, 'M18zZmRlM2YyYy01ZTc3LTRhOWItYTFjOS0yZmQ3YjFmNWEyYjc=', true,false, 3, 3);
insert into auth_tokens (id, value, valid, used, project_id, partner_id)
values (4, 'NF8zZmRlM2YyYy01ZTc3LTRhOWItYTFjOS0yZmQ3YjFmNWEyYjc=', true,false, 4, 4);
insert into auth_tokens (id, value, valid, used, project_id, partner_id)
values (5, 'NV8zZmRlM2YyYy01ZTc3LTRhOWItYTFjOS0yZmQ3YjFmNWEyYjc=', true,false, 5, 5);
insert into auth_tokens (id, value, valid, used, project_id, partner_id)
values (6, 'Nl8zZmRlM2YyYy01ZTc3LTRhOWItYTFjOS0yZmQ3YjFmNWEyYjc=', true,false, 6, 1);
insert into auth_tokens (id, value, valid, used, project_id, partner_id)
values (7, 'N18zZmRlM2YyYy01ZTc3LTRhOWItYTFjOS0yZmQ3YjFmNWEyYjc=', true,false, 7, 2);
