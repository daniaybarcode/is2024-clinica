package com.grupo3.is2024clinica.recycler;

import com.grupo3.is2024clinica.model.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonaService {
    public List<Persona> findAll() {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM personas";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(resultSet.getLong("id_persona"));
                persona.setCuil(resultSet.getLong("cuil"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setApellido(resultSet.getString("apellido"));
                persona.setDomicilio(resultSet.getString("domicilio"));
                persona.setTelefono(resultSet.getString("telefono"));
                persona.setEmail(resultSet.getString("email"));
                persona.setFechaDeNacimiento(resultSet.getString("fecha_nacimiento"));
                personas.add(persona);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personas;
    }

    public Optional<Persona> findById(Long id) {
        String sql = "SELECT * FROM personas WHERE id_persona = ?";
        Persona persona = null;

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                persona = new Persona();
                persona.setIdPersona(resultSet.getLong("id_persona"));
                persona.setCuil(resultSet.getLong("cuil"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setApellido(resultSet.getString("apellido"));
                persona.setDomicilio(resultSet.getString("domicilio"));
                persona.setTelefono(resultSet.getString("telefono"));
                persona.setEmail(resultSet.getString("email"));
                persona.setFechaDeNacimiento(resultSet.getString("fecha_nacimiento"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(persona);
    }

    public Persona save(Persona persona) {
        String sql = persona.getIdPersona() == null ?
                "INSERT INTO personas (cuil, nombre, apellido, domicilio, telefono, email, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?)" :
                "UPDATE personas SET cuil = ?, nombre = ?, apellido = ?, domicilio = ?, telefono = ?, email = ?, fecha_nacimiento = ? WHERE id_persona = ?";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setLong(1, persona.getCuil());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getApellido());
            statement.setString(4, persona.getDomicilio());
            statement.setString(5, persona.getTelefono());
            statement.setString(6, persona.getEmail());
            statement.setString(7, persona.getFechaDeNacimiento());

            if (persona.getIdPersona() != null) {
                statement.setLong(8, persona.getIdPersona());
            }

            statement.executeUpdate();

            if (persona.getIdPersona() == null) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    persona.setIdPersona(generatedKeys.getLong(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persona;
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM personas WHERE id_persona = ?";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
