package gm.Inventario.servicio;

import gm.Inventario.modelo.Producto;
import java.util.List;

public interface InterfazServicioProducto {

    List<Producto> listarProductos();
    Producto buscarProductoPorId(Integer id);
    Producto buscarProductoPorNombre(String nombre);
    Producto guardarProducto(Producto producto);
    boolean eliminarProductoPorId(Integer id);
    List<Producto> cincomascaros();
    List<Producto> stockmenoradiez();
    Producto actualizarProducto(Integer id,Producto producto);



}
