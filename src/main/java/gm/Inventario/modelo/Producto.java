package gm.Inventario.modelo;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotBlank(message = "El nombre del producto no puede estar vacio")
    @Column(nullable=false,length=60,unique=true)
    String nombre;

    @Column(nullable=false,length=100)
    String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser un número positivo")
    @Min(value = 0,message = "El precio no puede ser menor a $0")
    @Column(nullable=false,precision=10,scale=2)
    BigDecimal precio;

    @Column(nullable=false)
    @Min(value = 0,message = "El stock no puede ser negativo")
    @NotNull(message = "El Stock es obligatorio")
    Integer stock;


}





