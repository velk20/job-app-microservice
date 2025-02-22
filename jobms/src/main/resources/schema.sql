CREATE TABLE IF NOT EXISTS job
(
    id
    SERIAL
    PRIMARY
    KEY,
    title
    VARCHAR
(
    255
) NOT NULL,
    description TEXT,
    min_salary VARCHAR
(
    50
),
    max_salary VARCHAR
(
    50
),
    location VARCHAR
(
    255
),
    company_id BIGINT NOT NULL
    );