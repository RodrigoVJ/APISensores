package com.example.demo.Entidade;

import org.springframework.data.annotation.Id;

public class SensorTemperatura {

        @Id
        public String id;

        public double temperatura;

        public String timestamp;

        public SensorTemperatura() {}

        public SensorTemperatura(double temperatura, String timestamp) {
            this.temperatura = temperatura;
            this.timestamp= timestamp;
        }

        @Override
        public String toString() {
            return String.format(
                    "Sensor[id=%s, Valor='%s', Data='%s']",
                    id, temperatura, timestamp);
        }

}




