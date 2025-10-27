-- insert company values
insert into companies (id, name, legal_form, tax_number, vat_id)
values (1, 'Aventra Systems GmbH', 'GmbH', '123/456/7890', 'DE123456789');
insert into companies (id, name, legal_form, tax_number, vat_id)
values (2, 'Nordic Consult AG', 'AG', '987/654/3210', 'DE987654321');
insert into companies (id, name, legal_form, tax_number, vat_id)
values (3, 'BluePeak Innovations UG', 'UG', '112/233/4455', 'DE112233445');
insert into companies (id, name, legal_form, tax_number, vat_id)
values (4, 'EcoTech Solutions AG', 'AG', '667/788/9900', 'DE667788990');
insert into companies (id, name, legal_form, tax_number, vat_id)
values (5, 'DataCore SE', 'SE', '554/433/2211', 'DE554433221');

-- insert partners values
insert into partners (id, name, email, phone_number, job, company_id)
values (1, 'Julia Neumann', 'julia.neumann@aventra.de', '+49 30 2345678', 'Geschäftsführerin', 1);
insert into partners (id, name, email, phone_number, job, company_id)
values (2, 'Patrick Lehmann', 'patrick.lehmann@nordicconsult.de', '+49 89 1234987', 'Senior Consultant', 2);
insert into partners (id, name, email, phone_number, job, company_id)
values (3, 'Stefan Roth', 'stefan.roth@bluepeak.de', '+49 40 998822', 'Projektleiter', 3);
insert into partners (id, name, email, phone_number, job, company_id)
values (4, 'Miriam Bauer', 'miriam.bauer@ecotech.de', '+49 711 556677', 'Head of Sustainability', 4);
insert into partners (id, name, email, phone_number, job, company_id)
values (5, 'Tobias Krüger', 'tobias.krueger@datacore.de', '+49 69 443322', 'CTO', 5);

-- insert into addresses
insert into addresses (id, street, number, address_addition, city, zip_code, state, company_id)
values (1, 'Innovationsallee', '5', '3. OG', 'Berlin', '10117', 'Germany', 1);
insert into addresses (id, street, number, address_addition, city, zip_code, state, company_id)
values (2, 'Beraterring', '18', null, 'München', '80333', 'Germany', 2);
insert into addresses (id, street, number, address_addition, city, zip_code, state, company_id)
values (3, 'Hansebogen', '9', null, 'Hamburg', '20097', 'Germany', 3);
insert into addresses (id, street, number, address_addition, city, zip_code, state, company_id)
values (4, 'Nachhaltigkeitsweg', '22', null, 'Stuttgart', '70174', 'Germany', 4);
insert into addresses (id, street, number, address_addition, city, zip_code, state, company_id)
values (5, 'Digitalstraße', '77', null, 'Frankfurt am Main', '60313', 'Germany', 5);

-- insert into bank_details values
insert into bank_details (id, account_holder_name, iban, bic, bank_name, country, company_id)
values (1, 'Aventra Systems GmbH', 'DE89370400440532013000', 'COBADEFFXXX', 'Commerzbank', 'DE', 1);
insert into bank_details (id, account_holder_name, iban, bic, bank_name, country, company_id)
values (2, 'Nordic Consult AG', 'DE44500105175407324931', 'INGDDEFFXXX', 'ING', 'DE', 2);
insert into bank_details (id, account_holder_name, iban, bic, bank_name, country, company_id)
values (3, 'BluePeak Innovations UG', 'DE12500105170648489890', 'DEUTDEFFXXX', 'Deutsche Bank', 'DE', 3);
insert into bank_details (id, account_holder_name, iban, bic, bank_name, country, company_id)
values (4, 'EcoTech Solutions AG', 'DE22500105177891011121', 'BYLADEMMXXX', 'Sparkasse', 'DE', 4);
insert into bank_details (id, account_holder_name, iban, bic, bank_name, country, company_id)
values (5, 'DataCore SE', 'DE66500105176543219876', 'PBNKDEFFXXX', 'Postbank', 'DE', 5);

-- insert into auth_tokens values
insert into auth_tokens (id, value, valid, used, project_id, partner_id)
values (1, 'Q1JNIE9wdGltaWVydW5nXzQ1NTQzYjMxLTRlNzAtNDc3Mi1iZjc5LWRjMTFhM2ZjNGE4Yw==', false, true, 1, 1);
insert into auth_tokens (id, value, valid, used, project_id, partner_id)
values (2, 'QW5hbHl0aWNzIERhc2hib2FyZF9lYjA1NDk2MC1kYWE0LTQ5M2UtOGQ0Yy0yNjFjOTk4ZjY5YzM=', false, true, 2, 2);
insert into auth_tokens (id, value, valid, used, project_id, partner_id)
values (3, 'QnVzaW5lc3MgUHJvY2VzcyBSZWRlc2lnbl9iOTZkMzIwZC1jNGEwLTRhYjYtYmVmYS0xNTZmMGE5Njc5MzM=', false, true, 3, 3);
insert into auth_tokens (id, value, valid, used, project_id, partner_id)
values (4, 'SW9UIERhdGEgSHViX2FiMmY1YzNjLTNiNDAtNGIyMi1hMGVlLTEyMDMxOGYxOGNkYQ==', false, true, 4, 4);
insert into auth_tokens (id, value, valid, used, project_id, partner_id)
values (5, 'UHJlZGljdGl2ZSBNYWludGVuYW5jZSBTdWl0ZV83YjlmOWNmMS1kNDUyLTQ4MGYtOTk5ZC1mMGViNGZkMGNkMzM=', false, true, 5, 5);
