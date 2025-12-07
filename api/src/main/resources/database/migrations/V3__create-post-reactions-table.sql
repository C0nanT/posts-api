CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE post_reactions (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    post_id UUID NOT NULL,
    reaction_type VARCHAR(20) NOT NULL CHECK (reaction_type IN ('UPVOTE', 'NEUTRAL', 'DOWNVOTE')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (post_id) REFERENCES posts(id) ON DELETE CASCADE
);

CREATE INDEX idx_post_reactions_post_id ON post_reactions(post_id);

CREATE INDEX idx_post_reactions_type ON post_reactions(reaction_type);
