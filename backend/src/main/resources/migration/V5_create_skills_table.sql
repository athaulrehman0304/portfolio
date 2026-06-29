CREATE TABLE skills (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    display_order INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO skills (name, category, display_order) VALUES
('Java', 'Languages', 1),
('Python', 'Languages', 2),
('JavaScript', 'Languages', 3),
('TypeScript', 'Languages', 4),

('Spring Boot', 'Frameworks', 5),
('React', 'Frameworks', 6),
('Node.js', 'Frameworks', 7),

('PostgreSQL', 'Databases', 8),
('MySQL', 'Databases', 9),
('MongoDB', 'Databases', 10),

('Git', 'Tools', 11),
('GitHub', 'Tools', 12),
('Postman', 'Tools', 13),
('Maven', 'Tools', 14);
