package com.joaog4briel.ninjas.repository;

import com.joaog4briel.ninjas.entity.NinjaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<NinjaEntity, Long> {
}
