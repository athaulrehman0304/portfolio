CREATE TABLE contact_messages (
    id         BIGSERIAL     PRIMARY KEY,
    name       VARCHAR(100)  NOT NULL,
    email      VARCHAR(254)  NOT NULL,
    subject    VARCHAR(150)  NOT NULL,
    message    VARCHAR(5000) NOT NULL,
    created_at TIMESTAMPTZ   NOT NULL
);

CREATE INDEX idx_contact_messages_created_at ON contact_messages (created_at DESC);
