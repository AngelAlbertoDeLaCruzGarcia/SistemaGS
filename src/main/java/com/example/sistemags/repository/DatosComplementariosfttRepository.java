package com.example.sistemags.repository;

import com.example.sistemags.entity.DatosComplementariosftt;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DatosComplementariosfttRepository extends CrudRepository<DatosComplementariosftt, Integer> {

    Optional<DatosComplementariosftt> findByCurp(String rfc);
}
