package com.optimizarutas.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Escenario {
    private final String id;
    private final Deposito deposito;
    private final List<Vehiculo> vehiculos;
    private final List<Pedido> pedidos;

    public Escenario(
        String id,
        Deposito deposito,
        List<Vehiculo> vehiculos,
        List<Pedido> pedidos
    ) {
        if (id == null || id.isBlank()) {
            throw new  IllegalArgumentException(
                    "El ID del escenario es obligatorio"
            );
        }
        if  (deposito == null) {
            throw new  IllegalArgumentException(
                    "Indicar el deposito es obligatorio"
            );
        }
        if (vehiculos == null || vehiculos.isEmpty()) {
            throw new  IllegalArgumentException(
                    "Debe haber al menos un vehiculo en el escenario"
            );
        }
        if (pedidos == null || pedidos.isEmpty()) {
            throw new  IllegalArgumentException(
                    "El escenario debe tener al menos un pedido"
            );
        }

        Set<String> idsVehiculos = new HashSet<>();

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo == null) {
                throw new IllegalArgumentException(
                        "La lista de vehiculos no puede estar vacía"
                );
            }
            if (!idsVehiculos.add(vehiculo.getId())) {
                throw new IllegalArgumentException(
                        "ID de vehiculo duplicado: " + vehiculo.getId()
                );
            }
        }

        Set<String> idsPedidos = new HashSet<>();
        for  (Pedido pedido : pedidos) {
            if (pedido == null) {
                throw new   IllegalArgumentException(
                        "La lista de pedidos no puede estar vacía"
                );
            }
            if (!idsPedidos.add(pedido.getId())) {
                throw new IllegalArgumentException(
                        "ID de pedido duplicado" + pedido.getId()
                );
            }
        }

        this.id = id;
        this.deposito = deposito;
        this.vehiculos = vehiculos;
        this.pedidos = pedidos;
    }
    public String getId() {
        return id;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

}
