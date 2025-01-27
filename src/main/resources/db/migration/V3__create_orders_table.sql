CREATE TABLE orders (
    id INTEGER PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    workforce DOUBLE PRECISION NOT NULL,
    user_id INTEGER NOT NULL,
    part_id INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,
    CONSTRAINT fk_order_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_order_part FOREIGN KEY (part_id) REFERENCES parts (id)
);