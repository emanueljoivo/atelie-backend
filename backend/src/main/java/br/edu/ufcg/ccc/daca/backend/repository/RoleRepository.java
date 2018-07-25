package br.edu.ufcg.ccc.daca.backend.repository;


import br.edu.ufcg.ccc.daca.backend.entity.Role;
import br.edu.ufcg.ccc.daca.backend.constants.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}