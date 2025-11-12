package com.turism.turism_app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.turism.turism_app.models.entities.DeviceToken;

@Repository
public interface DeviceTokenRepository extends CrudRepository<DeviceToken,Long>{

}
