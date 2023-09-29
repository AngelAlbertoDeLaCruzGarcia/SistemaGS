package com.example.sistemags.service;

import com.example.sistemags.entity.Clientesftt;
import com.example.sistemags.repository.ClientesfttRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesfttService {

    @Autowired
    ClientesfttRepository clientesfttRepository;

    @Transactional(readOnly = true)
    public List<Clientesftt> list() {
        return (List<Clientesftt>) clientesfttRepository.findAll();
    }

    @Transactional
    public void save(Clientesftt clientesftt) {
        clientesfttRepository.save(clientesftt);
    }

    @Transactional(readOnly = true)
    public Optional<Clientesftt> getOneById(int id) {
        return clientesfttRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public boolean existsById(Integer id) {
        return clientesfttRepository.existsById(id);
    }

    @Transactional
    public void delete(int id) {
        clientesfttRepository.deleteById(id);
    }
}
