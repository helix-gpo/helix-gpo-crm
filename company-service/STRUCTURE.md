# Structure of Company Service

## Entities:
- Partner (id, name, email, phoneNumber, job, Company)
- Company (id, name)
- Address (id, street, number, addressAddition, city, zipCode, state)
- AuthToken (id, value, valid, used, Partner)

## Payload:
### Website:
- WebsitePartnerDto (id, name, job, WebsiteCompanyDto)
- WebsiteCompanyDto (id, name)
### CRM:
- PartnerDto (id, name, email, phoneNumber, job, CompanyDto)
- CompanyDto (id, name)

## Endpoints:

## Security:
- keycloak auth for endpoints (not for website)
- auth token check via oauth2 client (client credentials grant type)

## Auth Token Check:
- in this service

## Todos:
- methods to util class (if necessary)
- implement crm controller endpoints
- implement crm service methods
- add mapper methods for crm
### Website:
- implement security
- integrate aws s3 for company related documents
- add validation
- add exception handling (custom exceptions)
- add logs in services
- make corresponding service methods transactional
- secure initTestimonialProcess
- move security config urls to yml-config-file

## Ideas:
- cronjob to remove used auth token values from db
- save more information (tax nr., etc.)
