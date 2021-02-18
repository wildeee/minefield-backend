CREATE TABLE coordinate
(
   id bigint PRIMARY KEY NOT NULL,
   x int NOT NULL,
   y int NOT NULL,
   game_session_id bigint NOT NULL,
   bombs_around int NULL,
   revealed boolean NOT NULL,
   flagged boolean NOT NULL
);

ALTER TABLE coordinate
ADD CONSTRAINT fk_game_session
FOREIGN KEY (game_session_id)
REFERENCES game_session(id);