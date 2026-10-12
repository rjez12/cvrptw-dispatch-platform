package com.optimizarutas.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RutaTest {

    private final Vehiculo vehiculo = new Vehiculo(
            "V-01",
            10,
            LocalTime.of(9, 0),
            LocalTime.of(18,0)
    );

    private final Deposito deposito = new Deposito(
            "DEP-01",
            new Ubicacion(19.000, -94.000)
    );

    @Test
    void conservarSecuenciaSiCambieLaOriginal() {
        Pedido pedidoA = crearPedido("A");
        Pedido pedidoB = crearPedido("B");

        List<Pedido> pedidosOriginales = new ArrayList<>(
                List.of(pedidoA, pedidoB)
        );

        Ruta ruta = new Ruta(
                vehiculo,
                deposito,
                pedidosOriginales
        );

        pedidosOriginales.clear();

        assertEquals(
                List.of(pedidoA, pedidoB),
                ruta.getPedidos()
        );

    }
    @Test
    void impideModificarListaPedidosDeLaRuta() {
        Ruta ruta = new Ruta(
                vehiculo,
                deposito,
                List.of(crearPedido("A"))
        );

        assertThrows(
                UnsupportedOperationException.class,
                () -> ruta.getPedidos().clear()
        );
    }

    @Test
    void rechazarRutasSinPedido() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Ruta(vehiculo, deposito, List.of())
        );
    }

    private Pedido crearPedido(String id) {
        return new Pedido(
                id,
                new Ubicacion (19.422, -94.878),
                3,
                LocalTime.of(8,20),
                LocalTime.of(9,0),
                300
        );
    }
}
