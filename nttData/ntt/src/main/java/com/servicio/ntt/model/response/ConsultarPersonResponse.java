package com.servicio.ntt.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultarPersonResponse {
    
    private Integer totalRegistros;
    private Integer pagina;
    private Integer totalPaginas;
    private Integer registrosPorPagina;
	private List<EditPersonResponse> personas;

}
