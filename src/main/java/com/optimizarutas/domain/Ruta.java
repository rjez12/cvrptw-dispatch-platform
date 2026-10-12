package com.optimizarutas.domain;

import java.util.List;

public class Ruta {

    private final Vehiculo vehiculo;
    private final Deposito deposito;
    private final List<Pedido> pedidos;

    public Ruta(
            Vehiculo vehiculo,
            Deposito deposito,
            List<Pedido> pedidos
        ) {
        if (vehiculo == null) {
            throw new IllegalArgumentException(
                    "El vehiculo de la ruta no puede ser nulo"
            );
        }
        if (deposito == null) {
            throw new IllegalArgumentException(
                    "El deposito de la ruta es obligatorio"
            );
        }
        if (pedidos == null || pedidos.isEmpty()) {
            throw new IllegalArgumentException(
                    "La ruta debe tener al menos un pedido"
            );
        }

        for (Pedido pedido: pedidos) {
            if (pedido == null) {
                throw new IllegalArgumentException(
                        "La ruta no puede contener pedidos nulos"
                );
            }
        }
        this.vehiculo = vehiculo;
        this.deposito = deposito;
        this.pedidos = List.copyOf(pedidos);
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
