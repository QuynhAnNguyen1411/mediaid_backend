package com.mediaid.mediaid.DTO.staticData;

@FunctionalInterface
    public interface DTOMapper<E, D> {
        D map(E entity);
    }