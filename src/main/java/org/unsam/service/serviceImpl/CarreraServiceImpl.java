package org.unsam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.Carrera;
import org.unsam.repository.CarreraRepository;
import org.unsam.service.CarreraService;
import java.util.List;
import java.util.Optional;

@Service
public class CarreraServiceImpl implements CarreraService {
    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    public List<Carrera> listarCarreras() {
        return carreraRepository.findAll();
    }

    @Override
    public Optional<Carrera> obtenerCarreraPorId(Long id) {
        return carreraRepository.findById(id);
    }

    @Override
    public Carrera guardarCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    @Override
    public Optional<Carrera> actualizarCarrera(Long id, Carrera carrera) {
        Optional<Carrera> carreraOptional = obtenerCarreraPorId(id);
        if (carreraOptional.isPresent()) {
            Carrera carreraToUpdate = carreraOptional.get();
            carreraToUpdate.setNombre(carrera.getNombre());
            return Optional.of(guardarCarrera(carreraToUpdate));
        }
        return Optional.empty();
    }

    @Override
    public boolean eliminarCarrera(Long id) {
        Optional<Carrera> carreraOptional = obtenerCarreraPorId(id);
        if (carreraOptional.isPresent()) {
            carreraRepository.deleteById(id);
            return true;
        }
        return false;
    }
}