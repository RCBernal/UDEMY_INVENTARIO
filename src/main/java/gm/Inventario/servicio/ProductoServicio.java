package gm.Inventario.servicio;

import gm.Inventario.modelo.Producto;
import gm.Inventario.repositorio.ProductoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service  //Indica a Spring que esta clase contiene la lógica de negocio de la aplicación.
@Transactional
public class ProductoServicio implements InterfazServicioProducto{

    private final ProductoRepositorio productoRepositorio;
    public ProductoServicio(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;

    }

    @Override
    public List<Producto> listarProductos() {
        return (List<Producto>) productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer id) {
        return productoRepositorio.findById(id).orElseThrow(() -> new NoSuchElementException("Producto con el ID "+ id + " no encontrado"));
    }

    @Override
    public Producto buscarProductoPorNombre(String nombre) {
        return null;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public boolean eliminarProductoPorId(Integer id) {
        return productoRepositorio.findById(id)
                .map(producto -> {
                    productoRepositorio.deleteById(producto.getIdProducto());
                    return true;
                })
                .orElse(false);
    }

    @Override
    public List<Producto> cincomascaros() {
        return productoRepositorio.cincomascaros();
    }

    @Override
    public List<Producto> stockmenoradiez() {
        return productoRepositorio.stockmenoradiez();
    }

    @Override
    public Producto actualizarProducto(Integer id, Producto producto) {
        Producto productoExistente=this.productoRepositorio.findById(id).orElseThrow(()->new NoSuchElementException("Producto con el ID "+ id + " no encontrado"));
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setStock(producto.getStock());
        return this.productoRepositorio.save(productoExistente);
    }


}
