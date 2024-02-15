
package com.microservicio_hospital.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HospitalRepository {
    private final EntityManager entityManager;

    public HospitalRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void registrarHospital(Long idDistrito, String nombre, Integer antiguedad, Double area, Long idSede, Long idGerente, Long idCondicion) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("SP_HOSPITAL_REGISTRAR");
        storedProcedure.registerStoredProcedureParameter("p_idHospital", Long.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_idDistrito", Long.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_nombre", String.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_antiguedad", Integer.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_area", Double.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_idSede", Long.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_idGerente", Long.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_idCondicion", Long.class, jakarta.persistence.ParameterMode.IN);

//        storedProcedure.setParameter("p_idHospital", idHospital);
        storedProcedure.setParameter("p_idDistrito", idDistrito);
        storedProcedure.setParameter("p_nombre", nombre);
        storedProcedure.setParameter("p_antiguedad", antiguedad);
        storedProcedure.setParameter("p_area", area);
        storedProcedure.setParameter("p_idSede", idSede);
        storedProcedure.setParameter("p_idGerente", idGerente);
        storedProcedure.setParameter("p_idCondicion", idCondicion);

        storedProcedure.execute();
    }

    public void actualizarHospital(Long idDistrito, String nombre, Integer antiguedad, Double area, Long idSede, Long idGerente, Long idCondicion) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("SP_HOSPITAL_ACTUALIZAR");
        storedProcedure.registerStoredProcedureParameter("p_idHospital", Long.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_idDistrito", Long.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_nombre", String.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_antiguedad", Integer.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_area", Double.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_idSede", Long.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_idGerente", Long.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_idCondicion", Long.class, jakarta.persistence.ParameterMode.IN);

//        storedProcedure.setParameter("p_idHospital", idHospital);
        storedProcedure.setParameter("p_idDistrito", idDistrito);
        storedProcedure.setParameter("p_nombre", nombre);
        storedProcedure.setParameter("p_antiguedad", antiguedad);
        storedProcedure.setParameter("p_area", area);
        storedProcedure.setParameter("p_idSede", idSede);
        storedProcedure.setParameter("p_idGerente", idGerente);
        storedProcedure.setParameter("p_idCondicion", idCondicion);

        storedProcedure.execute();
    }

    public void eliminarHospital(Long idHospital) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("SP_HOSPITAL_ELIMINAR");
        storedProcedure.registerStoredProcedureParameter("p_idHospital", Long.class, jakarta.persistence.ParameterMode.IN);
        storedProcedure.setParameter("p_idHospital", idHospital);
        storedProcedure.execute();
    }

    public List<Object[]> listarHospitales() {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("SP_LISTAR_HOSPITALES");

        // Registro de parámetros de salida
        storedProcedure.registerStoredProcedureParameter("p_hospitales", void.class, ParameterMode.REF_CURSOR);

        // Ejecución del procedimiento almacenado
        storedProcedure.execute();

        // Obtención de los resultados
        List<Object[]> hospitales = storedProcedure.getResultList();

        return hospitales;
    }


}