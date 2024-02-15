package com.microservicio_hospital.controller;

import com.microservicio_hospital.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.microservicio_hospital.service.HospitalService;

import java.util.List;

@RestController
@RequestMapping("/hospitales")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;



    @PostMapping("/registrar")
    public ResponseEntity<String> registrarHospital(@RequestBody Hospital hospital) {
        try {
            Long idDistrito = hospital.getDistrito().getIdDistrito();
            Long idSede = hospital.getSede().getIdSede();
            Long idGerente = hospital.getGerente().getIdGerente();
            Long idCondicion = hospital.getCondicion().getIdCondicion();



            hospitalService.registrarHospital(idDistrito, hospital.getNombre(),
                    hospital.getAntiguedad(), hospital.getArea(), idSede, idGerente, idCondicion);
            return ResponseEntity.status(HttpStatus.CREATED).body("Hospital registrado correctamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los datos del hospital son inválidos.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el hospital.");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarHospital(@RequestBody Hospital hospital) {
        try {
            // Acceder a los ID de las entidades relacionadas
            Long idDistrito = hospital.getDistrito().getIdDistrito();
            Long idSede = hospital.getSede().getIdSede();
            Long idGerente = hospital.getGerente().getIdGerente();
            Long idCondicion = hospital.getCondicion().getIdCondicion();

            hospitalService.actualizarHospital(idDistrito, hospital.getNombre(),
                    hospital.getAntiguedad(), hospital.getArea(), idSede, idGerente, idCondicion);
            return ResponseEntity.status(HttpStatus.OK).body("Hospital actualizado correctamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los datos del hospital son inválidos.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el hospital.");
        }
    }


    @DeleteMapping("/eliminar/{idHospital}")
    public ResponseEntity<String> eliminarHospital(@PathVariable Long idHospital) {
        try {
            hospitalService.eliminarHospital(idHospital);
            return ResponseEntity.status(HttpStatus.OK).body("Hospital eliminado correctamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los datos del hospital son inválidos.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el hospital.");
        }
    }


    @GetMapping("/listar")
    public ResponseEntity<List<Object[]>> listarHospitales() {
        List<Object[]> hospitales = hospitalService.listarHospitales();
        return new ResponseEntity<>(hospitales, HttpStatus.OK);
    }

}
