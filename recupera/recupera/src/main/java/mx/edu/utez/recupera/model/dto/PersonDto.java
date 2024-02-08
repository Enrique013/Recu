package mx.edu.utez.recupera.model.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Integer id;
    private String username;
    private String password;
    private boolean activo;

}
