# Structure of Testimonials Service

## Entities:
- Testimonial (id, title, description, result, imageUrl, creationDate, lastUpdate, showOnWebsite, projectId)

## Payload:
- WebsiteTestimonialRequest (TestimonialDtoRequest, authTokenValue)
- TestimonialDtoRequest (id, title, description, result, showOnWebsite, projectId)
- TestimonialDtoResponse (id, title, description, result, image, creationDate, lastUpdate, showOnWebsite, WebsiteProjectDto)
### Website:
- WebsiteProjectDto (id, title, description, startDate, endDate, image, WebsitePartnerDto)
- WebsitePartnerDto (id, name, job, WebsiteCompanyDto)
- WebsiteCompanyDto (id, name)
### CRM:
- ProjectDto (id, title, description, startDate, endDate, creationDate, lastUpdate, status, price, image, showOnWebsite, PartnerDto)
- PartnerDto (id, name, email, phoneNumber, job, CompanyDto)
- CompanyDto (id, name)

## Endpoints:
- create Testimonial [/api/v1/testimonials/website] - POST (Website)
- get all Testimonials website [/api/v1/testimonials/website] - GET (Website)
- get all Testimonials average [/api/v1/testimonials/website/average] - GET (Website)
- create Testimonial [/api/v1/testimonials] - POST
- get all Testimonials [/api/v1/testimonials] - GET
- get Testimonial by ID [/api/v1/testimonials/{testimonialId}] - GET
- update Testimonial [/api/v1/testimonials/{testimonialId}] - PUT
- delete Testimonial [/api/v1/testimonials/{testimonialId}] - DELETE

## Security:
- keycloak auth for endpoints (not for website)
- auth token check via oauth2 client (client credentials grant type)

## Auth Token Check:
- request to projects-service with auth-token (internally calls company-service with auth-token)

## Todos:
- methods to util class (if necessary)
- implement other endpoints (in new controller)
- implement crm service methods
- implement security
- integrate an ftp server for images
- add validation
- add exception handling
- add logs in services
- get todos done
- implement RestClient for projects-service
- change controller pathing

## Ideas:
- different dto payloads for different controllers
