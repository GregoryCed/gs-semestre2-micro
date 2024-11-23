package com.github.gregoryced.gs_2semestre_micro.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.gregoryced.gs_2semestre_micro.dtos.EnergiaRequestCreateDto;
import com.github.gregoryced.gs_2semestre_micro.dtos.EnergiaRequestUpdateDto;
import com.github.gregoryced.gs_2semestre_micro.dtos.EnergiaResponseDto;
import com.github.gregoryced.gs_2semestre_micro.model.Energia;

@Component
public class EnergiaMapper {
	@Autowired
    private ModelMapper modelMapper;

    public EnergiaResponseDto toDto(Energia energia) {
        return modelMapper.map(energia, EnergiaResponseDto.class);
    }

    public Energia toModel(EnergiaRequestCreateDto dto) {
        return modelMapper.map(dto, Energia.class);
    }

    public Energia toModel(Long id, EnergiaRequestUpdateDto dto) {
        Energia result = modelMapper.map(dto, Energia.class);
        result.setId(id);
        return result;
    } 
}
