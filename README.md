### 📃 **About the Project**

This microservice web app is designed to streamline hotel operations by managing reservations, check-ins/outs, staff scheduling, inventory, and billing. It provides a user-friendly interface for hotel owners and staff to enhance efficiency and improve guest experiences.

###  **Main Features**

-   **Backend Microservices:** There are 7 microservices, built using **Spring Boot** (Java) and **NestJS** (JavaScript/TypeScript).
    1.  **Customer Review Service:** Manages customer reviews and ratings.
    2.  **Auxiliary Services Service:** Likely handles additional hotel services (e.g., room service, concierge).
    3.  **Parking Service:** Manages parking reservations, spot availability, and payments.
    4.  **Inventory Service:** Manages hotel assets like rooms and facilities, including availability and booking.
    5.  **Reservation Service:** Manages reservation lifecycle (create, modify, cancel).
    6.  **Staff Management Service:** Handles staff scheduling, payroll, and HR tasks.
    7.  **Authentication Service:** Ensures secure access to the system.

###  **Technical Architecture**

The system is designed with a microservices architecture, with different services communicating through a gateway and discovered via the **Eureka** server. Here's a summary of the modules:

1.  **Client-side:** The frontend is built with **Angular 15**.
2.  **Gateway-service:** Acts as a proxy/gateway for routing requests to appropriate services.
3.  **Eureka Server:** A service discovery server using **Spring Cloud Eureka**.
4.  **Microservices Modules:**
    -   **ms_customer_review:** Manages customer reviews and ratings.
    -   **ms_auxiliary_services:** Likely handles additional services (room service, etc.).
    -   **ms_parking:** Manages hotel parking reservations and payments.
    -   **ms_inventory:** Handles room and facility availability and bookings.
    -   **ms_reservation:** Manages hotel reservations, modifications, and cancellations.
    -   **ms_staff:** Manages hotel staff schedules, payroll, and HR functionalities.
