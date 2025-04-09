package com.mediaid.mediaid.DTO.staticData;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TemplateDuLieuTinhDTO {
    private int ID;
    private String ten;

    public TemplateDuLieuTinhDTO(int ID, String ten) {
        this.ID = ID;
        this.ten = ten;
    }

    // Generic method to map a single entity to DTO
    public static <E, D> D mapEntityToDTO(E entity, DTOMapper<E, D> mapper) {
        return mapper.map(entity);
    }

    // Generic method to map a list of entities to a list of DTOs
    public static <E, D> List<D> mapEntityListToDTOList(List<E> entities, DTOMapper<E, D> mapper) {
        List<D> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(mapper.map(entity)));
        return dtos;
    }

    // Functional Interface for mapping logic

}
