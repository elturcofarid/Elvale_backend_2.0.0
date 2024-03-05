package com.onlysystems.negocio.fiao.service;

import com.onlysystems.negocio.fiao.entity.FiaoDto;
import com.onlysystems.negocio.fiao.entity.FiaoModel;
import com.onlysystems.negocio.fiao.repository.FiaoRepository;
import com.onlysystems.negocio.usuario.mapper.GenericMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FiaoServiceImpl implements FiaoService{


    @Autowired
    private FiaoRepository fiaoRepository;

    GenericMapper<FiaoDto, FiaoModel> mapper = new GenericMapper<>();

    private static Logger logger = LoggerFactory.getLogger(FiaoServiceImpl.class);


    @Override
    public List<FiaoDto> consultarFiao() {
        logger.info("Consultando fiao");
        List<FiaoDto> fiaos = new ArrayList<>();
         fiaoRepository.findAll().stream().forEach(fiao -> fiaos.add(mapper.mapEntityToDto(fiao, FiaoDto.class)));
       return fiaos;
    }



    @Override
    public UUID registrar(FiaoDto fiao) {
        return fiaoRepository.save(mapper.mapDtoToEntity(fiao,FiaoModel.class)).getId();
    }

    @Override
    public void actualizar(FiaoDto fiao) {
        throw new UnsupportedOperationException();
    }
}
