package br.com.zuco.unitetests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static br.com.zuco.mapper.ObjectDozerMapper.parseListObjects;
import static br.com.zuco.mapper.ObjectDozerMapper.parseObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.zuco.dto.EstiloDTO;
import br.com.zuco.model.entity.Estilo;
import br.com.zuco.unitetests.mapper.mocks.MockEstilo;

public class ObjectDozerMapperTests {
	
	MockEstilo inputObject;

	@BeforeEach
    public void setUp() {
        inputObject = new MockEstilo();
    }

    @Test
    public void parseEntityToDTOTest() {
        EstiloDTO output = parseObject(inputObject.mockEntity(), EstiloDTO.class);
        assertEquals(Long.valueOf(0L), output.getEstiloId());
        assertEquals("Estilo0", output.getEstiloNome());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<EstiloDTO> outputList = parseListObjects(inputObject.mockEntityList(), EstiloDTO.class);
        EstiloDTO outputZero = outputList.get(0);
        assertEquals(Long.valueOf(0L), outputZero.getEstiloId());
        assertEquals("Nome do Estilo0", outputZero.getEstiloNome());

        EstiloDTO outputSeven = outputList.get(7);
        assertEquals(Long.valueOf(7L), outputSeven.getEstiloId());
        assertEquals("Nome do Estilo7", outputSeven.getEstiloNome());

        EstiloDTO outputTwelve = outputList.get(12);
        assertEquals(Long.valueOf(12L), outputTwelve.getEstiloId());
        assertEquals("Nome do Estilo12", outputTwelve.getEstiloNome());
    }

    @Test
    public void parseDTOToEntityTest() {
        Estilo output = parseObject(inputObject.mockDTO(), Estilo.class);
        assertEquals(Long.valueOf(0L), output.getEstiloId());
        assertEquals("Nome do Estilo0", output.getEstiloNome());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<Estilo> outputList = parseListObjects(inputObject.mockDTOList(), Estilo.class);
        Estilo outputZero = outputList.get(0);
        assertEquals(Long.valueOf(0L), outputZero.getEstiloId());
        assertEquals("Nome do Estilo0", outputZero.getEstiloNome());

        Estilo outputSeven = outputList.get(7);
        assertEquals(Long.valueOf(7L), outputSeven.getEstiloId());
        assertEquals("Nome do Estilo7", outputSeven.getEstiloNome());

        Estilo outputTwelve = outputList.get(12);
        assertEquals(Long.valueOf(12L), outputTwelve.getEstiloId());
        assertEquals("Nome do Estilo12", outputTwelve.getEstiloNome());
    }
    
}
