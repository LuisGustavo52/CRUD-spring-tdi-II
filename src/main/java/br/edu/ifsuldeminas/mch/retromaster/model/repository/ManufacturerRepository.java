package br.edu.ifsuldeminas.mch.retromaster.model.repository;

import br.edu.ifsuldeminas.mch.retromaster.model.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
}