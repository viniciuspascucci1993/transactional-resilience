package com.yourname.transactionalresilience.domain.model;

import com.yourname.transactionalresilience.domain.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class Payment {

    private final UUID paymentId;
    private final String idempotencyKey;
    private final BigDecimal amount;
    private PaymentStatus status;
    private final Instant createdAt;
    private Instant lastUpdatedAt;

    public Payment(UUID paymentId, String idempotencyKey, BigDecimal amount,
                   PaymentStatus status, Instant createdAt, Instant lastUpdatedAt) {
        this.paymentId = paymentId;
        this.idempotencyKey = idempotencyKey;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
