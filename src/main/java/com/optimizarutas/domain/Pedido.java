package com.optimizarutas.domain;

import java.time.LocalTime;

public class Pedido {

    private final Ubicacion ubicacion;
    private final String id;
    private final int demanda;
    private final LocalTime inicioVentana;
    private final LocalTime finVentana;
    private final int duracionServicioSegundos;

    public String getId() {
        return id;
    }

    public int getDemanda() {
        return demanda;
    }

    public LocalTime getInicioVentana() {
        return inicioVentana;
    }

    public LocalTime getFinVentana() {
        return finVentana;
    }

    public int getDuracionServicioSegundos() {
        return duracionServicioSegundos;
    }
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public Pedido(
            String id,
            Ubicacion ubicacion,
            int demanda,
            LocalTime inicioVentana,
            LocalTime finVentana,
            int duracionServicioSegundos
    ) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException(
                    "El ID es obligatorio."
            );
        }
        if (demanda <= 0) {
            throw new IllegalArgumentException(
                    "La demanda debe ser mayor de 0."
            );
        }
        if (inicioVentana == null || finVentana == null) {
            throw new IllegalArgumentException(
                    "Los horarios de Ventana son necesarios para el pedido."
            );
        }
        if (finVentana.isBefore(inicioVentana)) {
            throw new IllegalArgumentException(
                    "El cierre de Ventana no puede ser antes que el inicio de ventada."
            );
        }
        if (duracionServicioSegundos <= 0) {
            throw new IllegalArgumentException(
                    "El tiempo total del servicio no puede ser 0 ni menor que este."
            );
        }
        if (ubicacion == null) {
            throw new IllegalArgumentException(
                    "La ubicación del pedido es obligatoria."
            );
        }

        this.id = id.trim();
        this.demanda = demanda;
        this.inicioVentana = inicioVentana;
        this.finVentana = finVentana;
        this.duracionServicioSegundos = duracionServicioSegundos;
        this.ubicacion = ubicacion;
    }
}