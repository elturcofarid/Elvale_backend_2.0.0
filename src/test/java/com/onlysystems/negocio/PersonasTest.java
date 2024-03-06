package com.onlysystems.negocio;

import com.onlysystems.negocio.persona.entity.PersonaDto;
import com.onlysystems.negocio.persona.entity.PersonaModel;
import com.onlysystems.negocio.persona.repository.PersonaRepository;
import com.onlysystems.negocio.persona.service.PersonaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonasTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonaRepository repositorioPersonas;

    @Autowired
    private PersonaService servicioPersonas;

    @Test
    public void testConsultarPersonas() {
        List<PersonaDto> esperado = new ArrayList();
        assertEquals(esperado, servicioPersonas.consultar());
    }

    @Test
    public void testRegistrarPersonas(){

        PersonaDto personaDto = new PersonaDto();
        personaDto.setId(java.util.UUID.randomUUID());
        personaDto.setNombre("nombre");
        personaDto.setDireccion("direccion");
        personaDto.setEmail("elturcofarid@gmzil.com");
        personaDto.setTelefono("318373738");

        when(repositorioPersonas.save(Mockito.any(PersonaModel.class)))
                .thenAnswer(invocation -> {
                    PersonaModel personaGuardada = invocation.getArgument(0);
                    personaGuardada.setId(UUID.randomUUID());
                    return personaGuardada;
                });

        UUID resultado = servicioPersonas.registrar(personaDto);
        assertNotNull(resultado);
    }
}
