package com.posts.api.domains.post_reaction;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import java.util.UUID;

@Table(name = "post_reactions")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostReaction {

    @Id
    @GeneratedValue()
    private UUID id;
    
    private UUID post_id;
    private EnumReactionType reaction_type;
}
