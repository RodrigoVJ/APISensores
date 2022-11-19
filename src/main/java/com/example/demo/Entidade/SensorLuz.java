package com.example.demo.Entidade;

import org.springframework.data.annotation.Id;

public class SensorLuz {
    @Id
    public String id;

    public int luximetro;

    public String timestamp;

    public SensorLuz() {}

    public SensorLuz(int luximetro, String timestamp) {
        this.luximetro = luximetro;
        this.timestamp= timestamp;
    }

    @Override
    public String toString() {
        return String.format(
                "Sensor[id=%s, Valor='%s', Data='%s']",
                id, luximetro, timestamp);
    }


}
