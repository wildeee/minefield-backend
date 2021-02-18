package br.com.minefield.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Coordinate extends PanacheEntity {

    @Column(nullable = false)
    private Integer x;

    @Column(nullable = false)
    private Integer y;

    @ManyToOne
    @JoinColumn(name = "game_session_id", nullable = false)
    private GameSession gameSession;

    @Column(name = "bombs_around", nullable = false)
    private Integer bombsAround;

    @Column(nullable = false)
    private Boolean revealed;

    @Column(nullable = false)
    private Boolean flagged;

    @Column(nullable = false)
    private Boolean bomb;

    protected Coordinate() { /* For Hibernate */ }

    private Coordinate(Builder builder) {
        this.id = builder.id;
        this.x = builder.x;
        this.y = builder.y;
        this.gameSession = builder.gameSession;
        this.bombsAround = builder.bombsAround;
        this.revealed = builder.revealed;
        this.flagged = builder.flagged;
        this.bomb = builder.bomb;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public GameSession getGameSession() {
        return gameSession;
    }

    public Integer getBombsAround() {
        return bombsAround;
    }

    public Boolean getRevealed() {
        return revealed;
    }

    public Boolean getFlagged() {
        return flagged;
    }

    public Boolean getBomb() {
        return bomb;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private Integer x;
        private Integer y;
        private GameSession gameSession;
        private Integer bombsAround;
        private Boolean revealed;
        private Boolean flagged;
        private Boolean bomb;

        private Builder() {
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withX(Integer x) {
            this.x = x;
            return this;
        }

        public Builder withY(Integer y) {
            this.y = y;
            return this;
        }

        public Builder withGameSession(GameSession gameSession) {
            this.gameSession = gameSession;
            return this;
        }

        public Builder withBombsAround(Integer bombsAround) {
            this.bombsAround = bombsAround;
            return this;
        }

        public Builder withRevealed(Boolean revealed) {
            this.revealed = revealed;
            return this;
        }

        public Builder withFlagged(Boolean flagged) {
            this.flagged = flagged;
            return this;
        }

        public Builder withBomb(Boolean bomb) {
            this.bomb = bomb;
            return this;
        }

        public Coordinate build() {
            return new Coordinate(this);
        }
    }
}
