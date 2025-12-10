package com.posts.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posts.api.domains.type.Type;
import com.posts.api.repositories.TypeRepository;

import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    /**
     * Find or create a type by name
     * If the type doesn't exist, creates a new one
     * 
     * @param typeName The name of the type
     * @return The found or created type
     */
    public Type findOrCreateType(String typeName) {
        Optional<Type> existingType = typeRepository.findByName(typeName);

        if (existingType.isPresent()) {
            return existingType.get();
        }

        Type newType = new Type();
        newType.setName(typeName);

        return typeRepository.save(newType);
    }

    /**
     * Find a type by name
     * 
     * @param typeName The name of the type
     * @return Optional containing the type if found
     */
    public Optional<Type> findByName(String typeName) {
        return typeRepository.findByName(typeName);
    }
}
