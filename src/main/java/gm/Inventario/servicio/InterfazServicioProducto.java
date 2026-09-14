package gm.Inventario.servicio;

import gm.Inventario.modelo.Producto;
import java.util.List;

public interface InterfazServicioProducto {

    List<Producto> listarProductos();
    Producto buscarProductoPorId(Integer id);
    Producto buscarProductoPorNombre(String nombre);
    Producto guardarProducto(Producto producto);
    void eliminarProductoPorId(Integer id);


}
