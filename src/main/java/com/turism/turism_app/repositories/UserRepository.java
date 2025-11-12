package com.turism.turism_app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.turism.turism_app.models.entities.Users;

@Repository
public interface UserRepository extends CrudRepository<Users,Long> {

    Optional<Users> findByEmail(String email);
}
