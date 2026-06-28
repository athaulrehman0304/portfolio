CREATE TABLE projects (
    id             BIGSERIAL     PRIMARY KEY,
    title          VARCHAR(200)  NOT NULL,
    description    VARCHAR(2000) NOT NULL,
    repository_url VARCHAR(500),
    live_url       VARCHAR(500),
    image_url      VARCHAR(500),
    featured       BOOLEAN       NOT NULL DEFAULT FALSE,
    display_order  INTEGER       NOT NULL DEFAULT 0,
    created_at     TIMESTAMPTZ   NOT NULL,
    updated_at     TIMESTAMPTZ   NOT NULL
);

CREATE TABLE project_tags (
    project_id BIGINT      NOT NULL,
    tag        VARCHAR(50) NOT NULL,
    tag_order  INTEGER     NOT NULL,
    CONSTRAINT pk_project_tags PRIMARY KEY (project_id, tag_order),
    CONSTRAINT fk_project_tags_project
        FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE
);

CREATE INDEX idx_projects_display_order ON projects (display_order ASC, created_at DESC);
CREATE INDEX idx_project_tags_project_id ON project_tags (project_id);
