CREATE TABLE parts (
    id INTEGER PRIMARY KEY,
    part_name VARCHAR(255) NOT NULL,
    vehicle_model VARCHAR(255) NOT NULL,
    vehicle_brand VARCHAR(255) NOT NULL,
    vehicle_year INTEGER NOT NULL,
    unity_price DOUBLE PRECISION NOT NULL,
    quantity INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);