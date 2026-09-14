package gm.Inventario.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "usuario", schema = "inventario_db")
public class  Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 50)
    @NotNull
    @Column(name = "ap_paterno", nullable = false, length = 50)
    private String apPaterno;

    @Size(max = 50)
    @NotNull
    @Column(name = "ap_materno", nullable = false, length = 50)
    private String apMaterno;

    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Size(max = 255)
    @NotNull
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Size(max = 15)
    @Column(name = "telefono", length = 15)
    private String telefono;

    @NotNull
    @Lob
    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Size(max = 18)
    @NotNull
    @Column(name = "curp", nullable = false, length = 18)
    private String curp;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @ColumnDefault("'activo'")
    @Lob
    @Column(name = "estatus")
    private String estatus;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_registro")
    private Instant fechaRegistro;

    @Column(name = "ultimo_login")
    private Instant ultimoLogin;


}