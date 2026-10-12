package com.optimizarutas.domain;

import java.util.OptionalInt;

public class MatrizTiempos {

    private final int[][] tiempoSegundos;

    public MatrizTiempos(int[][] tiempoSegundos) {
        if (tiempoSegundos == null || tiempoSegundos.length == 0) {
            throw new IllegalArgumentException
                    (
                            "La matriz debe contener al menos un punto."
                    );
        }

        int cantidadPuntos = tiempoSegundos.length;
        this.tiempoSegundos = new int[cantidadPuntos][];

        for (int origen = 0; origen < cantidadPuntos; origen++) {
            int[] fila = tiempoSegundos[origen];

            if (fila == null || fila.length != cantidadPuntos) {
                throw new IllegalArgumentException(
                        "La matriz debe ser cuadrada y no tener filas nulas"
                );
            }

            for (int destino = 0; destino < cantidadPuntos; destino++) {
                if (fila[destino] < -1) {
                    throw new IllegalArgumentException(
                            "Los tiempos deben ser no negativos o -1 si no hay ruta"
                    );
                }

                if (origen == destino && fila[destino] != 0) {
                    throw new IllegalArgumentException(
                            "El tiempo de un punto hacia si mismo debe de ser cero"
                    );
                }
                this.tiempoSegundos[origen] = fila.clone();
            }
        }
    }

    public int getCantidadPuntos() {
        return tiempoSegundos.length;
    }

    public OptionalInt getTiempoSegundos(int origen, int destino) {
        validarIndice(origen);
        validarIndice(destino);

        int tiempo = tiempoSegundos[origen][destino];

        if (tiempo == -1) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(tiempo);
    }

    private void validarIndice(int indice) {
        if (indice < 0 || indice >= tiempoSegundos.length) {
            throw new IllegalArgumentException(
                    "índice de punto fuera de rango: " + indice
            );
        }
    }
}