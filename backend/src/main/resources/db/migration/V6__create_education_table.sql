CREATE TABLE education (
    id BIGSERIAL PRIMARY KEY,
    institution VARCHAR(255) NOT NULL,
    degree VARCHAR(255) NOT NULL,
    year VARCHAR(50) NOT NULL,
    description TEXT NOT NULL,
    display_order INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO education
(institution, degree, year, description, display_order)
VALUES

(
'St Martin''s Engineering College',
'B.Tech in Computer Science',
'2021 - 2025',
'Computer Science Engineering gave me a strong foundation in programming, data structures, databases, operating systems, computer networks and software development.',
1
),

(
'Narayana Junior College',
'Intermediate (MPC)',
'2019 - 2021',
'Completed Intermediate with MPC and secured 90 percent.',
2
),

(
'Martins Grammar High School',
'SSC',
'2018 - 2019',
'Completed SSC with 9.0 CGPA.',
3
);
