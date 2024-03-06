package com.onlysystems.negocio;

import com.onlysystems.negocio.fiao.entity.FiaoDto;
import com.onlysystems.negocio.fiao.entity.FiaoModel;
import com.onlysystems.negocio.fiao.repository.FiaoRepository;
import com.onlysystems.negocio.fiao.service.FiaoService;
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
public class FiaoTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FiaoRepository repositorio;

    @Autowired
    private FiaoService servicio;

    @Test
    public void testConsultarFiaos() {
        List<FiaoDto> esperado = new ArrayList();
        assertEquals(esperado, servicio.consultarFiao());
    }

    @Test
    public void testRegistrarFiao(){

        FiaoDto fiao = new FiaoDto();
        fiao.setId(UUID.randomUUID());


        when(repositorio.save(Mockito.any(FiaoModel.class)))
                .thenAnswer(invocation -> {
                    FiaoModel fiaoGuardada = invocation.getArgument(0);
                    fiaoGuardada.setId(UUID.randomUUID());
                    return fiaoGuardada;
                });

        UUID resultado = servicio.registrar(fiao);
        assertNotNull(resultado);
    }
}
