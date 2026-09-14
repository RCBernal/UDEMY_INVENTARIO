package gm.Inventario.modelo;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //corresponde a un valor auto incrementable
    Integer idProducto;

    @Column(nullable=false,length=60,unique=true)
    String nombre;

    @Column(nullable=false,length=100)
    String descripcion;

    @Column(nullable=false,precision=10,scale=2)
    BigDecimal precio;

    @Column(nullable=false)
    @Min(value = 0,message = "El stock no puede ser negativo")
    Integer stock;


}





