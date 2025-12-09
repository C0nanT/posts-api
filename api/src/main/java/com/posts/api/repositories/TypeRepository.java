package com.posts.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.posts.api.domains.type.Type;

import java.util.Optional;
import java.util.UUID;

public interface TypeRepository extends JpaRepository<Type, UUID> {
    
    /**
     * Find a type by its name
     * 
     * @param name The type name
     * @return Optional containing the type if found
     */
    Optional<Type> findByName(String name);
}
