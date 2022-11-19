package com.example.demo.Repositorio;


import com.example.demo.Entidade.SensorLuz;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SensorLuzRepository extends MongoRepository <SensorLuz,String> {

    public SensorLuz findByid(String id);
    public List<SensorLuz> findByluximetro(int luximetro);



}
