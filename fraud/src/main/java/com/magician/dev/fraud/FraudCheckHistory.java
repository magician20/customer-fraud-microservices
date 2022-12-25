package com.magician.dev.fraud;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(
            name = "fraud_id_seq",
            sequenceName = "fraud_id_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraud_id_seq"
    )
    private Long id;
    @NotNull
    private Long customerId;
    @NotNull
    private Boolean isFraudster;

    @CreatedDate
    private LocalDateTime createdAt;
}
