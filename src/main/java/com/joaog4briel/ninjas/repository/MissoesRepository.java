package com.joaog4briel.ninjas.repository;

import com.joaog4briel.ninjas.entity.MissoesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissoesRepository extends JpaRepository<MissoesEntity, Long> {
}
