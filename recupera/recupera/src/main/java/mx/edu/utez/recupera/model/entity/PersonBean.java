package mx.edu.utez.recupera.model.entity;

import jakarta.persistence.*;
import lombok.*;
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class PersonBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username", unique = true)
    private String username;
    @Column (name = "password")
    private String password;
    @Column (name = "estatus")
    private boolean activo;
}
