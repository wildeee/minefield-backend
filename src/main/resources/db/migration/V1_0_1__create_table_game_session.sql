CREATE TABLE game_session
(
   id bigint PRIMARY KEY NOT NULL,
   rows int NOT NULL,
   cols int NOT NULL,
   bombs_amount int NOT NULL,
   started_at timestamp NOT NULL
);