package gm.Inventario.controlador;

import gm.Inventario.modelo.Producto;
import gm.Inventario.servicio.InterfazServicioProducto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4020")  //Permite la conexion desde angular
public class ProductosControlador {

    private final InterfazServicioProducto interfazServicioProducto;

    public ProductosControlador(InterfazServicioProducto interfazServicioProducto) {
        this.interfazServicioProducto = interfazServicioProducto;
    }

    //Listar todos los productos
    @GetMapping("/all")
    public ResponseEntity<List<Producto>> obtenerProductos() {
        return ResponseEntity.ok(interfazServicioProducto.listarProductos());
    }
}
