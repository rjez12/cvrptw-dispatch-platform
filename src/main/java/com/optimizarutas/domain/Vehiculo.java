package com.optimizarutas.domain;

import java.time.LocalTime;

public class Vehiculo {
    private final String id;
    private final int capacidad;
    private final LocalTime inicioJornada;
    private final LocalTime finJornada;

    public Vehiculo(
        String id,
        int capacidad,
        LocalTime inicioJornada,
        LocalTime finJornada
    ) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException(
                    "El ID del vehiculo es obligatorio"
            );
        }
        if (capacidad <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad del vehiculo no puede ser igual a 0 o menor que este"
            );
        }
        if (inicioJornada == null || finJornada == null) {
            throw new IllegalArgumentException(
                    "Los horarios de jornada son obligatorios."
            );
        }
        if (!finJornada.isAfter(inicioJornada)) {
            throw new IllegalArgumentException(
                    "El fin de la jornada no puede ser antes que el inicio de la jornada."
            );
        }

        this.id = id.trim();
        this.capacidad = capacidad;
        this.inicioJornada = inicioJornada;
        this.finJornada = finJornada;
    }

    public String getId() {
        return id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public LocalTime getInicioJornada() {
        return inicioJornada;
    }

    public LocalTime getFinJornada() {
        return finJornada;
    }
}
