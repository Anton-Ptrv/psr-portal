alter table volunteers alter column login_telegram drop not null;

ALTER TABLE volunteers ADD COLUMN user_id bigint;