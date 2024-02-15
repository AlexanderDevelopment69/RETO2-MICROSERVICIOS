package com.microservicio_hospital.service;

import com.microservicio_hospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;


    public void registrarHospital(Long idDistrito, String nombre, Integer antiguedad, Double area, Long idSede, Long idGerente, Long idCondicion) {
        hospitalRepository.registrarHospital(idDistrito, nombre, antiguedad, area, idSede, idGerente, idCondicion);
    }

    public void actualizarHospital( Long idDistrito, String nombre, Integer antiguedad, Double area, Long idSede, Long idGerente, Long idCondicion) {
        hospitalRepository.actualizarHospital( idDistrito, nombre, antiguedad, area, idSede, idGerente, idCondicion);
    }

    public void eliminarHospital(Long idHospital) {
        hospitalRepository.eliminarHospital(idHospital);
    }

    public List<Object[]> listarHospitales() {
        return hospitalRepository.listarHospitales();
    }

}
