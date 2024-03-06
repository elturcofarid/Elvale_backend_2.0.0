package com.onlysystems.negocio;

import com.onlysystems.negocio.cliente.entity.CLienteModel;
import com.onlysystems.negocio.cliente.entity.ClienteDto;
import com.onlysystems.negocio.cliente.repository.ClienteRepository;
import com.onlysystems.negocio.cliente.service.ClienteService;
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
public class ClienteTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteRepository repositorio;

    @Autowired
    private ClienteService servicio;

    @Test
    public void testConsultarClientes() {
        List<ClienteDto> esperado = new ArrayList();
        assertEquals(esperado, servicio.consultarCliente());
    }

    @Test
    public void testRegistrarCliente(){

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(UUID.randomUUID());
        clienteDto.setCliente(new PersonaDto());
        clienteDto.setReferencia(new PersonaDto());

        when(repositorio.save(Mockito.any(CLienteModel.class)))
                .thenAnswer(invocation -> {
                    CLienteModel clienteGuardada = invocation.getArgument(0);
                    clienteGuardada.setId(UUID.randomUUID());
                    return clienteGuardada;
                });

        UUID resultado = servicio.registrar(clienteDto);
        assertNotNull(resultado);
    }
}
