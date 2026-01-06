# Roadmap — Transactional Resilience

## Phase 1 — Core Domain (In Progress)

- [x] Project bootstrap (Spring Boot, profiles, local env)
- [x] Hexagonal architecture base structure
- [x] Initial domain aggregate definition (Payment)
- [ ] Payment creation rules and invariants
- [ ] Payment state transitions (approve / fail)

## Phase 2 — Idempotency & Consistency

- [ ] Idempotency key handling
- [ ] Idempotency record model
- [ ] Transactional Outbox model
- [ ] Outbox event publisher (async)

## Phase 3 — Application Layer

- [ ] Create payment use case
- [ ] Ports (in / out)
- [ ] Application services

## Phase 4 — Infrastructure

- [ ] REST API (controllers, DTOs)
- [ ] Persistence (JPA adapters)
- [ ] Database migrations
- [ ] Dockerized application

## Phase 5 — Observability & Ops

- [ ] Structured logging
- [ ] Correlation IDs
- [ ] Basic metrics
