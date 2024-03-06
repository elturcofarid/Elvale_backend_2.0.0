package com.onlysystems.negocio;

import com.onlysystems.negocio.establecimiento.entity.EstablecimientoDto;
import com.onlysystems.negocio.establecimiento.entity.EstablecimientoModel;
import com.onlysystems.negocio.establecimiento.repository.EstablecimientoRepository;
import com.onlysystems.negocio.establecimiento.service.EstablecimientoService;
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
public class EstablecmientoTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstablecimientoRepository repositorio;

    @Autowired
    private EstablecimientoService servicio;

    @Test
    public void testConsultarPersonas() {
        List<EstablecimientoDto> esperado = new ArrayList();
        assertEquals(esperado, servicio.consultar());
    }

    @Test
    public void testRegistrarPersonas(){

        EstablecimientoDto establecimiento = new EstablecimientoDto();
        establecimiento.setId(UUID.randomUUID());
        establecimiento.setNombre("nombre");
        establecimiento.setDireccion("direccion");
        establecimiento.setNit(123456);
        establecimiento.setTelefono("318373738");

        when(repositorio.save(Mockito.any(EstablecimientoModel.class)))
                .thenAnswer(invocation -> {
                    EstablecimientoModel establecimientoGuardada = invocation.getArgument(0);
                    establecimientoGuardada.setId(UUID.randomUUID());
                    return establecimientoGuardada;
                });

        UUID resultado = servicio.registrar(establecimiento);
        assertNotNull(resultado);
    }
}
