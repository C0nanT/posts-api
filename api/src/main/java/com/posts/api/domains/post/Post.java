package com.posts.api.domains.post;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import java.util.Date;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.posts.api.domains.type.Type;

@Table(name = "posts")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue()
    private UUID id;

    private String title;
    private String content;
    private String image_url;
    
    @CreationTimestamp
    private Date created_at;
    
    @UpdateTimestamp
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
}
