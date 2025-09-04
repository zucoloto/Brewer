package br.com.zuco.unitetests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.zuco.dto.EstiloDTO;
import br.com.zuco.model.entity.Estilo;

public class MockEstilo {
	
	public Estilo mockEntity() {
		return mockEntity(0);
	}
	
	public EstiloDTO mockDTO() {
		return mockDTO(0);
	}
	
	public List<Estilo> mockEntityList() {
		List<Estilo> estilos = new ArrayList<Estilo>();
		for (int i = 0; i < 14; i++) {
			estilos.add(mockEntity(i));
		}
		return estilos;
	}

	public List<EstiloDTO> mockDTOList() {
        List<EstiloDTO> estilos = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            estilos.add(mockDTO(i));
        }
        return estilos;
    }

    public Estilo mockEntity(Integer number) {
        Estilo estilo = new Estilo();
        estilo.setEstiloNome("Nome do Estilo: " + number);
        return estilo;
    }

    public EstiloDTO mockDTO(Integer number) {
    	EstiloDTO estiloDTO = new EstiloDTO();
    	estiloDTO.setEstiloNome("Nome do EstiloDTO: " + number);
        return estiloDTO;
    }
    
}
