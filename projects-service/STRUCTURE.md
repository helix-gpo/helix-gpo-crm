# Structure of Projects Service

## Entities:
- Project (id, title, description, startDate, endDate, creationDate, lastUpdate, status, price, imageUrl, showOnWebsite, partnerId)
- Milestone (id, title, description, startDate, endDate, status, price, Project)
- Invoices (id, invoiceNumber, description, issueDate, dueDate, totalNetAmount, totalTaxAmount, totalGrossAmount, reasonForPayment, status, vatIdSeller, vatIdBuyer, eInvoiceFormat, eInvoiceRecipient, Milestone, [currency, paymentMethod])

### Enums:
- ProjectStatus (planned, active, on-hold, review, approved, canceled)
- MilestoneStatus (planned, in-progress, review, approved, canceled)
- InvoiceStatus (draft, sent, paid, partially-paid, overdue, canceled)

## Payload:
### Website:
- WebsiteProjectDto (id, title, description, startDate, endDate, image, WebsitePartnerDto)
- WebsitePartnerDto (id, name, job, WebsiteCompanyDto)
- WebsiteCompanyDto (id, name)
### CRM:
- ProjectDto (id, title, description, startDate, endDate, creationDate, lastUpdate, status, price, image, showOnWebsite, PartnerDto)
- MilestoneDto (id, title, description, startDate, endDate, status, price, ProjectDto)
- InvoiceDto (id, title, amount, deadline, status, MilestoneDto)
- PartnerDto (id, name, email, phoneNumber, job, CompanyDto)
- CompanyDto (id, name)

## Endpoints:
### Projects:
- get all Projects website [/api/v1/projects/website] - GET (Website)
- create Project [/api/v1/projects] - POST
- get all Projects [/api/v1/projects] - GET
- get Project by ID [/api/v1/projects/{projectId}] - GET
- update Project [/api/v1/projects/{projectId}] - PUT
- delete Project [/api/v1/projects/{projectId}] - DELETE
### Milestones:
- add Milestone [/api/v1/milestones/{projectId}] - POST
- get all Milestones for one Project [/api/v1/milestones/{projectId}] - GET
- get Milestone by ID [/api/v1/milestones/{projectId}/{milestoneId}] - GET
- update Milestone [/api/v1/milestones/{projectId}/{milestoneId}] - PUT
- delete Milestone [/api/v1/milestones/{projectId}/{milestoneId}] - DELETE
### Invoices:
- add Invoice [/api/v1/invoices/{projectId}/{milestoneId}] - POST
- get all Invoices for one Project [/api/v1/invoices/{projectId}] - GET
- get Invoice by ID [/api/v1/invoices/{projectId}/{milestoneId}/{invoiceId}] - GET
- get Invoice by Milestone [/api/v1/invoices/{projectId}/{milestoneId}] - GET
- update Invoice [/api/v1/invoices/{projectId}/{milestoneId}/{invoiceId}] - PUT
- delete Invoice [/api/v1/invoices/{projectId}/{milestoneId}/{invoiceId}] - DELETE

## Security:
- keycloak auth for endpoints (not for website)
- auth token check via oauth2 client (client credentials grant type)

## Auth Token Check:
- request to company-service (with auth-token)

## Todos:
- methods to util class (if necessary)
- implement crm controller endpoints
- implement crm service methods
- add mapper methods for crm
- add invoice - data for e-invoice! (invoice number, order number, positions, etc.)
### Website:
- implement security
- integrate aws s3 for images and invoices (documents)
- add validation
- add exception handling (custom exceptions)
- add logs in services
- get todos done
- make corresponding service methods transactional

## Ideas:
- endpoint for final projects structure with overview ready for customers (dashboard)
- cronjob for overdue invoices
- consider brutto/netto
- double check invoices before sending
- templates for e-invoices