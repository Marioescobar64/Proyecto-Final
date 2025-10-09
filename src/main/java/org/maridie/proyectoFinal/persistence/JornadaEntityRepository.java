package org.maridie.proyectoFinal.persistence;
import org.maridie.proyectoFinal.dominio.dto.JornadaDto;
import org.maridie.proyectoFinal.dominio.repository.JornadaRepository;
import org.maridie.proyectoFinal.persistence.crud.CrudJornadaRepository;
import org.maridie.proyectoFinal.persistence.entity.jornadaEntity;
import org.maridie.proyectoFinal.persistence.mapper.jornadaMapper;


import java.util.List;
import java.util.Optional;


public class JornadaEntityRepository implements JornadaRepository {

    private final CrudJornadaRepository crudJornadaRepository;
    private final jornadaMapper jornadaMapper;

    public JornadaEntityRepository(CrudJornadaRepository crudJornadaRepository, jornadaMapper jornadaMapper) {
        this.crudJornadaRepository = crudJornadaRepository;
        this.jornadaMapper = jornadaMapper;
    }

    @Override
    public List<JornadaDto> obtenerTodo() {
        return this.jornadaMapper.toDto(this.crudJornadaRepository.findAll());
    }

    @Override
    public JornadaDto buscarPorId(Integer id) {
        Optional<jornadaEntity> jornada = this.crudJornadaRepository.findById(id);
        return jornada.map(jornadaMapper::toDto).orElse(null);
    }

    @Override
    public JornadaDto guardar(JornadaDto jornadaDto) {
        jornadaEntity jornada = this.jornadaMapper.toEntity(jornadaDto);
        return this.jornadaMapper.toDto(this.crudJornadaRepository.save(jornada));
    }

    @Override
    public void eliminar(Integer id) {
        this.crudJornadaRepository.deleteById(id);
    }
}