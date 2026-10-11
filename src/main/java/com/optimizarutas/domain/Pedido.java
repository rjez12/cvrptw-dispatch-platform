package com.optimizarutas.domain;

import java.time.LocalTime;

public class Pedido {

    private final String id;
    private final int demanda;
    private final LocalTime inicioVentana;
    private final LocalTime finVentana;
    private final int duracionServicioSegundos;

    public Pedido(
            String id,
            int demanda,
            LocalTime inicioVentana,
            LocalTime finVentana,
            int duracionServicioSegundos
    ) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException(
                    "El ID es obligatorio"
            );
        }
        if (demanda <= 0) {
            throw new IllegalArgumentException(
                    "La demanda debe ser mayor de 0"
            );
        }
        if (inicioVentana == null || finVentana == null) {
            throw new IllegalArgumentException(
                    "Los horarios de Ventana son necesarios para el pedido"
            );
        }
        if (finVentana.isBefore(inicioVentana)) {
            throw new IllegalArgumentException(
                    "El cierre de Ventana no puede ser antes que el inicio de ventada"
            );
        }

        this.id = id;
        this.demanda = demanda;
        this.inicioVentana = inicioVentana;
        this.finVentana = finVentana;
        this.duracionServicioSegundos = duracionServicioSegundos;
    }
}