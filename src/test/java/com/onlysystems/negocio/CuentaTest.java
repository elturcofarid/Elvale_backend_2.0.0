package com.onlysystems.negocio;

import com.onlysystems.negocio.cuenta.entity.CuentaDto;
import com.onlysystems.negocio.cuenta.entity.CuentaModel;
import com.onlysystems.negocio.cuenta.repository.CuentaRepository;
import com.onlysystems.negocio.cuenta.service.CuentaService;
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
public class CuentaTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CuentaRepository repositorio;

    @Autowired
    private CuentaService servicio;

    @Test
    public void testConsultarCuentas() {
        List<CuentaDto> esperado = new ArrayList();
        assertEquals(esperado, servicio.consultar());
    }

    @Test
    public void testRegistrarCuentas(){

        CuentaDto cuentaDto = new CuentaDto();
        cuentaDto.setId(UUID.randomUUID());


        when(repositorio.save(Mockito.any(CuentaModel.class)))
                .thenAnswer(invocation -> {
                    CuentaModel cuentaGuardada = invocation.getArgument(0);
                    cuentaGuardada.setId(UUID.randomUUID());
                    return cuentaGuardada;
                });

        UUID resultado = servicio.registrar(cuentaDto);
        assertNotNull(resultado);
    }
}
