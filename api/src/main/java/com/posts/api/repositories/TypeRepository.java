package com.posts.api.repositories;
import com.posts.api.domain.type.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TypeRepository extends JpaRepository<Type, UUID> {

}
