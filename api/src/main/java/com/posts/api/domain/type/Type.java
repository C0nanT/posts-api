package com.posts.api.domain.type;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import java.util.UUID;

@Table(name = "types")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Type {
    @Id
    @GeneratedValue()
    private UUID id;

    private String name;
}
