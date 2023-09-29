package com.example.sistemags.service;

import com.example.sistemags.entity.DatosComplementariosftt;
import com.example.sistemags.repository.DatosComplementariosfttRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DatosComplementariosfttService {

    @Autowired
    DatosComplementariosfttRepository datosComplementariosfttRepository;

    @Transactional(readOnly = true)
    public List<DatosComplementariosftt> list() {
        return (List<DatosComplementariosftt>) datosComplementariosfttRepository.findAll();
    }

    @Transactional
    public void save(DatosComplementariosftt datosComplementariosftt) {
        datosComplementariosfttRepository.save(datosComplementariosftt);
    }

    @Transactional(readOnly = true)
    public Optional<DatosComplementariosftt> getOneById(int id) {
        return datosComplementariosfttRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<DatosComplementariosftt> getOneByCurp(String curp) {
        return datosComplementariosfttRepository.findByCurp(curp);
    }

    @Transactional(readOnly = true)
    public boolean existsById(Integer id) {
        return datosComplementariosfttRepository.existsById(id);
    }

    @Transactional
    public void delete(int id) {
        datosComplementariosfttRepository.deleteById(id);
    }
}
