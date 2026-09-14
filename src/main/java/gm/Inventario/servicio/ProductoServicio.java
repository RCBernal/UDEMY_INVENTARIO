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
        return productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer id) {
        return productoRepositorio.findById(id).orElse(null);
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
    public void eliminarProductoPorId(Integer id) {
        if(!productoRepositorio.existsById(id)){
            throw new NoSuchElementException("No existe el producto con el id: " + id);
        }
        productoRepositorio.deleteById(id);
    }
}
