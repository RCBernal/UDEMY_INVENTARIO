package gm.Inventario.controlador;

import gm.Inventario.modelo.Producto;
import gm.Inventario.repositorio.ProductoRepositorio;
import gm.Inventario.servicio.InterfazServicioProducto;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventario-app")  //http://localhost:8080/api/productos/stock
@CrossOrigin(origins = "http://localhost:4020")  //Permite la conexion desde angular
public class ProductosControlador {

    private final InterfazServicioProducto interfazServicioProducto;
    private static final Logger logger = LoggerFactory.getLogger(ProductosControlador.class);
    private final ProductoRepositorio productoRepositorio;

    public ProductosControlador(InterfazServicioProducto interfazServicioProducto, ProductoRepositorio productoRepositorio) {
        this.interfazServicioProducto = interfazServicioProducto;
        this.productoRepositorio = productoRepositorio;
    }

    //Listar todos los productos
    @GetMapping("/all")
    public ResponseEntity<List<Producto>> obtenerProductos() {
        logger.info("Iniciando obtenerProductos");

        List<Producto> productos =interfazServicioProducto.listarProductos();
        logger.info("Se encontraron {} productos", productos.size());
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/toop5")
    public ResponseEntity<List<Producto>> obtenerCincoProductosCaros() {
        return ResponseEntity.ok(interfazServicioProducto.cincomascaros());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(interfazServicioProducto.buscarProductoPorId(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarProductoPorId(@PathVariable Integer id) {
        boolean deleted=this.interfazServicioProducto.eliminarProductoPorId(id);
        return (deleted) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/stock")
    public ResponseEntity<List<Producto>> obtenerStockmenoradiez() {
        return ResponseEntity.ok(this.interfazServicioProducto.stockmenoradiez());
    }

    @PostMapping("/save")
    public ResponseEntity<Producto> SaveProduct(@RequestBody @Valid Producto producto) {
        logger.info("Iniciando Guardado de producto: {}",producto);
        Producto nuevoproducto=this.interfazServicioProducto.guardarProducto(producto);
        logger.info("Producto {} guardado correctamente",nuevoproducto.getNombre());
        return  ResponseEntity.status(HttpStatus.CREATED).body(nuevoproducto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Producto> UpdateProducto(@PathVariable Integer id,@RequestBody    Producto producto) {
        logger.info("Iniciando Actualizacion de producto: {}",id);
        Producto updateProducto=this.interfazServicioProducto.actualizarProducto(id,producto);
        logger.info("Producto {} actualizado correctamente",updateProducto.getNombre());
        return  ResponseEntity.ok(updateProducto);

    }
}
