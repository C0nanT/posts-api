package com.posts.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.posts.api.domains.type.Type;

import java.util.UUID;

public interface TypeRepository extends JpaRepository<Type, UUID> {

}
