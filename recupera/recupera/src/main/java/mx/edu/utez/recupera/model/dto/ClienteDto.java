package mx.edu.utez.recupera.model.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    private Integer id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String direccion;
}
