package com.info2023.tpfinal.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "game_task")
public class GameTask {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy="org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID uuid;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String description;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate deadline;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusTask status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;


    public enum StatusTask {
        PENDING("Pending"),
        IN_PROGRESS("In progress"),
        COMPLETED("Completed");

        private final String value;

        StatusTask(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
