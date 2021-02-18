ALTER TABLE game_session
ADD COLUMN status varchar(11) NOT NULL DEFAULT '';

ALTER TABLE game_session
ALTER COLUMN status DROP DEFAULT;