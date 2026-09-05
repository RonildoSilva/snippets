CREATE TABLE cidadaos(
    id SERIAL PRIMARY KEY,
    dias_trabalhados BIGINT, 
    nome VARCHAR(1000), 
    dt_nascimento TIMESTAMP, 
    alfabetizado bool, 
    renda FLOAT);

-- ALTER TABLE cidadaos DROP CONSTRAINT cidadao_unq;
-- ALTER TABLE cidadaos DROP CONSTRAINT cidadao_unq;

ALTER TABLE cidadaos
ADD CONSTRAINT cidadao_unq UNIQUE(id);

ALTER TABLE cidadaos 
ALTER COLUMN nome SET NOT NULL;

DROP INDEX dt_nascimento_idx;

CREATE UNIQUE INDEX dt_nascimento_idx ON cidadaos(dt_nascimento);
CREATE UNIQUE INDEX id_idx ON cidadaos(id);

-- CREATE INDEX in 14 secs 174 msec.

INSERT INTO cidadaos (dias_trabalhados, nome, dt_nascimento, alfabetizado, renda)
SELECT
 (random() * 10000)::bigint, -- generates a random integer between 0 and 10,000, which is cast to a bigint 
 ARRAY_TO_STRING(ARRAY(SELECT chr((65 + (random() * 25))::int) FROM generate_series(1, (1000*random())::int)), ''), -- generates a random string of characters of variable length, where each character is an uppercase letter (A-Z), and concatenates them into a single string without any delimiter.
 NOW() - random() * INTERVAL '365 days', -- generates a random date within the past year 
 random() < 0.5, -- generates a random boolean value (true or false) 
 random() * 5000 -- generates a random floating-point number between 0 and 100
FROM generate_series(1, 1000000);



----------
