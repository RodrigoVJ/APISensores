package com.example.demo.Controlador;


import com.example.demo.Entidade.SensorTemperatura;
import com.example.demo.Entidade.SensorLuz;
import com.example.demo.Exceptions.SensorIDMismatchException;
import com.example.demo.Exceptions.SensorNotFoundException;
import com.example.demo.Repositorio.SensorLuzRepository;
import com.example.demo.Repositorio.SensorTemperaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class Controlador {
    @Autowired
    private SensorTemperaturaRepository sensorTemperaturaRepository;
    @Autowired
    private SensorLuzRepository sensorLuzRepository;

    @GetMapping("/")
    public List<Object> GetSensors() {
        List<Object> newList = Stream.concat(sensorTemperaturaRepository.findAll().stream(), sensorLuzRepository.findAll().stream()).toList(); //junta as 2 listas
        return newList;
        //return sensorRepository.findAll();
    }

    @GetMapping("/temp/{id}")
    public SensorTemperatura GetSensorTemperatura(@PathVariable String id) {
        return sensorTemperaturaRepository.findById(id).orElseThrow(SensorNotFoundException::new);
    }

    @GetMapping("/luz/{id}")
    public SensorLuz GetSensorluz(@PathVariable String id) {
        return sensorLuzRepository.findById(id).orElseThrow(SensorNotFoundException::new);
    }


        //fazer verificaçao se ID já existe? ou substituir logo?
    @PostMapping("/temp")
    @ResponseStatus(HttpStatus.CREATED)
    public SensorTemperatura PostSensorTemp(@RequestBody SensorTemperatura sensorTemperatura) {
        sensorTemperatura.timestamp= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        return sensorTemperaturaRepository.save(sensorTemperatura);
    }

    @PostMapping("/luz")
    @ResponseStatus(HttpStatus.CREATED)
    public SensorLuz PostSensorLuz(@RequestBody SensorLuz sensorLuz) {
        sensorLuz.timestamp= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        return sensorLuzRepository.save(sensorLuz);
    }


    @PutMapping("/temp")
    public SensorTemperatura PutSensorTemp(@RequestBody SensorTemperatura sensorTemperatura) {
        SensorTemperatura oldSensorTemperatura = sensorTemperaturaRepository.findById(sensorTemperatura.id).orElseThrow(SensorNotFoundException::new);
        oldSensorTemperatura.temperatura = sensorTemperatura.temperatura;
        oldSensorTemperatura.timestamp= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        return sensorTemperaturaRepository.save(oldSensorTemperatura);
    }

    @PutMapping("/luz")
    public SensorLuz PutSensorLuz(@RequestBody SensorLuz sensorLuz) {
        SensorLuz oldSensorLuz= sensorLuzRepository.findById(sensorLuz.id).orElseThrow(SensorNotFoundException::new);
        oldSensorLuz.luximetro = sensorLuz.luximetro;
        oldSensorLuz.timestamp= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        return sensorLuzRepository.save(oldSensorLuz);
    }


    @DeleteMapping("/temp/{id}")
    public String DeleteSensorTemp(@PathVariable String id) throws Exception {
        if(sensorTemperaturaRepository.findByid(id)==null)
            throw new SensorNotFoundException("Sensor com id:"+id+" não encontrado.");
        else {
            sensorTemperaturaRepository.deleteById(id);
            return id;
        }
    }

    @DeleteMapping("/luz/{id}")
    public String DeleteSensorLuz(@PathVariable String id) throws Exception {
        if(sensorLuzRepository.findByid(id)==null)
            throw new SensorNotFoundException("Sensor com id:"+id+" não encontrado.");
        else {
            sensorLuzRepository.deleteById(id);
            return id;
        }
    }

}
