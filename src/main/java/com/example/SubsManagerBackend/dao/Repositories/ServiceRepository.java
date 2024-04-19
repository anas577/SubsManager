package com.example.SubsManagerBackend.dao.Repositories;

import com.example.SubsManagerBackend.dao.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
