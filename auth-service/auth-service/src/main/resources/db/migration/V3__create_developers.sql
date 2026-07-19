CREATE TABLE developers (
    id BIGSERIAL PRIMARY KEY,
    company_name VARCHAR(100) NOT NULL,
    organization VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    user_id BIGINT UNIQUE,

    CONSTRAINT fk_developer_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
);