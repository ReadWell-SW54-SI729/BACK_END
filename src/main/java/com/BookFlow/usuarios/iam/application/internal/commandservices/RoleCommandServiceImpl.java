package com.BookFlow.usuarios.iam.application.internal.commandservices;

import com.BookFlow.usuarios.iam.domain.model.commands.SeedRolesCommand;
import com.BookFlow.usuarios.iam.domain.model.entities.Role;
import com.BookFlow.usuarios.iam.domain.model.valueobjects.Roles;
import com.BookFlow.usuarios.iam.domain.services.RoleCommandService;
import com.BookFlow.usuarios.iam.infrastructure.persistence.jpa.repositories.RoleRepository;



import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleCommandServiceImpl implements RoleCommandService {
    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void handle(SeedRolesCommand command) {
        Arrays.stream(Roles.values()).forEach(role -> {
            if (role == Roles.ROLE_USER) {
                // Para ROLE_USER, asegúrate de que siempre exista
                createRoleIfNotExists(role);
            } else {
                // Para otros roles, verifica y crea si no existen
                createRoleIfNotExists(role);
            }
        });
    }
    private void createRoleIfNotExists(Roles role) {
        if (!roleRepository.existsByName(role)) {
            Role newRole = new Role(role);
            roleRepository.save(newRole);
        }
    }
}
