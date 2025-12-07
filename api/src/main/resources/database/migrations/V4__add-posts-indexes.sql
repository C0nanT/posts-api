
CREATE INDEX idx_posts_type_id ON posts(type_id);
CREATE INDEX idx_posts_created_at ON posts(created_at);
CREATE INDEX idx_posts_title ON posts(title);
CREATE INDEX idx_posts_type_created ON posts(type_id, created_at);
