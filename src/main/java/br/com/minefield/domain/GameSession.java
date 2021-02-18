package br.com.minefield.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "game_session")
public class GameSession extends PanacheEntity {

    @Column(nullable = false)
    private Integer rows;

    @Column(nullable = false)
    private Integer cols;

    @Column(name = "started_at", nullable = false)
    private LocalDateTime startedAt;

    @Column(name = "bombs_amount", nullable = false)
    private Integer bombsAmount;

    private GameSession(Builder builder) {
        this.id = builder.id;
        this.rows = builder.rows;
        this.cols = builder.cols;
        this.startedAt = builder.startedAt;
        this.bombsAmount = builder.bombsAmount;
    }

    protected GameSession() { /* For Hibernate */ }

    public Integer getRows() {
        return rows;
    }

    public Integer getCols() {
        return cols;
    }

    public Integer getBombsAmount() {
        return bombsAmount;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private Integer rows;
        private Integer cols;
        private LocalDateTime startedAt;
        private Integer bombsAmount;

        private Builder() {
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withRows(Integer rows) {
            this.rows = rows;
            return this;
        }

        public Builder withCols(Integer cols) {
            this.cols = cols;
            return this;
        }

        public Builder withStartedAt(LocalDateTime startedAt) {
            this.startedAt = startedAt;
            return this;
        }

        public Builder withBombsAmount(Integer bombsAmount) {
            this.bombsAmount = bombsAmount;
            return this;
        }

        public GameSession build() {
            return new GameSession(this);
        }
    }
}
