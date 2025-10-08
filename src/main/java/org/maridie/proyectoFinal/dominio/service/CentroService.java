package org.maridie.proyectoFinal.dominio.service;

import lombok.Data;
import org.maridie.proyectoFinal.dominio.dto.centroDto;
import org.maridie.proyectoFinal.dominio.repository.CentroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

    @Service
    @Data
    public class CentroService {
        private final CentroRepository centroRepository;

        public CentroService(CentroRepository centroRepository) {
            this.centroRepository = centroRepository;
        }

        public List<centroDto> obtenerTodo() {
            return this.centroRepository.obtenerTodo();
        }

        public centroDto buscarPorId(Integer id) {
            return this.centroRepository.buscarPorId(id);
        }

        public centroDto guardar(centroDto centroDto) {
            return this.centroRepository.guardar(centroDto);
        }

        @Transactional
        public void eliminar(Integer id) {
            this.centroRepository.eliminar(id);
        }
    }



