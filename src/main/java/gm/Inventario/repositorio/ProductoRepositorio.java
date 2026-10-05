package gm.Inventario.repositorio;

import gm.Inventario.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepositorio extends CrudRepository<Producto, Integer> {

    @Query(value="SELECT * FROM productos ORDER BY precio DESC LIMIT 5",nativeQuery = true)
    List<Producto> cincomascaros();

    @Query(value="SELECT * FROM productos where stock <=10",nativeQuery = true)
    List<Producto> stockmenoradiez();
}
