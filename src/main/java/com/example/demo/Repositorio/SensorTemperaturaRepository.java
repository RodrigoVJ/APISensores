package com.example.demo.Repositorio;

import com.example.demo.Entidade.SensorTemperatura;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SensorTemperaturaRepository extends MongoRepository<SensorTemperatura, String> {


        public SensorTemperatura findByid(String id);
        public List<SensorTemperatura> findBytemperatura(int temperatura);



}
