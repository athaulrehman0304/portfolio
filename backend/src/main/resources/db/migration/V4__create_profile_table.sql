CREATE TABLE profile (
    id BIGSERIAL PRIMARY KEY,

    name VARCHAR(100) NOT NULL,
    headline VARCHAR(200) NOT NULL,
    bio TEXT NOT NULL,

    location VARCHAR(100),
    email VARCHAR(150),
    degree VARCHAR(150),
    availability VARCHAR(100),

    github_url VARCHAR(255),
    linkedin_url VARCHAR(255),
    resume_url VARCHAR(255),
    profile_image VARCHAR(255),

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO profile (
    name,
    headline,
    bio,
    location,
    email,
    degree,
    availability,
    github_url,
    linkedin_url,
    resume_url,
    profile_image
)
VALUES (
    'Athaul Rehman',
    'Software Developer',
    'Computer Science graduate passionate about building full-stack web applications and continuously improving software development skills.',
    'India',
    'ataul0917@gmail.com',
    'B.Tech in Computer Science',
    'Open to Work',
    'https://github.com/athaulrehman0304',
    'https://linkedin.com/in/athaul',
    '',
    ''
);