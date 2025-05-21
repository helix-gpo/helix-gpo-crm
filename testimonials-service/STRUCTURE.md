# Structure of Testimonials Service

## Entities:
- Testimonial (id, title, description, result, image, companyId, projectId)

## Payload:
- WebsiteTestimonialRequest (TestimonialDtoRequest, authTokenValue)
- TestimonialDtoRequest (id, title, description, result, showOnWebsite, companyId, projectId)
- TestimonialDtoResponse (id, title, description, result, image, companyName, partnerName, projectName)
- Project (id, name, Partner)
- Partner (id, name, job, Company)
- Company (id, name)

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

## Auth Token Check:
- part of company-/project-service

## Todos:
- add logs in services
- methods to util class (if necessary)
