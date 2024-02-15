
package com.microservicio_usuario.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {

    private final EntityManager entityManager;

    public UsuarioRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void registrarUsuario(String nombres, String apellidos, String email, String password) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("SP_REGISTRAR_USUARIO");
        storedProcedure.registerStoredProcedureParameter("p_nombres", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_apellidos", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_email", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_password", String.class, ParameterMode.IN);

        storedProcedure.setParameter("p_nombres", nombres);
        storedProcedure.setParameter("p_apellidos", apellidos);
        storedProcedure.setParameter("p_email", email);
        storedProcedure.setParameter("p_password", password);

        storedProcedure.execute();
    }


    public Long iniciarSesion(String email, String password) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("SP_INICIAR_SESION");
        storedProcedure.registerStoredProcedureParameter("p_email", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_password", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("p_id_usuario", Long.class, ParameterMode.OUT);

        storedProcedure.setParameter("p_email", email);
        storedProcedure.setParameter("p_password", password);

        storedProcedure.execute();

        return (Long) storedProcedure.getOutputParameterValue("p_id_usuario");
    }
}
