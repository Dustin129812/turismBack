package com.turism.turism_app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.turism.turism_app.models.entities.Locations;

@Repository
public interface LocationRepository extends CrudRepository<Locations,Long>{

}
