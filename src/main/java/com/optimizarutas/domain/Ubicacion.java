package com.optimizarutas.domain;

public class Ubicacion {
    private final double latitud;
    private final double longitud;

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public Ubicacion(double latitud, double longitud) {
        if (!Double.isFinite(latitud)
            || latitud < -90 || latitud > 90) {
            throw new IllegalArgumentException(
                    "La latidud debe ser un número entre 90 y -90"
            );
        }
        if (!Double.isFinite(longitud)
            || longitud < -180 || longitud > 180) {
            throw new IllegalArgumentException(
                    "La longitud debe ser un número entre 180 y -180"
            );
        }

        this.latitud = latitud;
        this.longitud = longitud;


    }
}