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
            hospitalService.registrarHospital(hospital.getIdDistrito(), hospital.getNombre(),
                    hospital.getAntiguedad(), hospital.getArea(), hospital.getIdSede(), hospital.getIdGerente(),
                    hospital.getIdCondicion());
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
            hospitalService.actualizarHospital(hospital.getIdDistrito(), hospital.getNombre(),
                    hospital.getAntiguedad(), hospital.getArea(), hospital.getIdSede(), hospital.getIdGerente(),
                    hospital.getIdCondicion());
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
