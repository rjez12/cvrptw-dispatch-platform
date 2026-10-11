package com.optimizarutas.domain;

public class Deposito {

    private final String id;
    private final Ubicacion ubicacion;

    public  Deposito(String id, Ubicacion ubicacion) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException(
                    "El ID del deposito es obligatorio."
            );
        }
        if (ubicacion == null) {
            throw new IllegalArgumentException(
                    "La ubicación del déposito es obligatoria."
            );
        }
        this.id = id.trim();
        this.ubicacion = ubicacion;
    }
    public String getId() {
        return id;
    }
    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
