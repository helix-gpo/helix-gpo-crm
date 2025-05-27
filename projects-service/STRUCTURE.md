# Structure of Projects Service

## Entities:
- Project (id, title, description, startDate, endDate, imageUrl, showOnWebsite, partnerId)
- Milestone (id, title, description, startDate, endDate, milestoneStatus, price, Project)
- Invoices (id, title, amount, invoiceStatus, Milestone)

## Payload:
- ProjectDto (id, title, description, startDate, endDate, image, showOnWebsite)
- MilestoneDto (id, title, description, startDate, endDate, milestoneStatus, price, ProjectDto)
- InvoiceDto (id, title, amount, invoiceStatus, MilestoneDto)
- PartnerDto (id, name, job, Company)
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
- implement endpoints
- implement security
- integrate an ftp server for images and invoices
- add validation
- add exception handling
- add logs in services
- get todos done
- implement RestClient for company-service
