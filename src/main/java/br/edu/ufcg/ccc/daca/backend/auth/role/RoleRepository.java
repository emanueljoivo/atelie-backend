package br.edu.ufcg.ccc.daca.backend.auth.role;


import br.edu.ufcg.ccc.daca.backend.auth.role.Role;
import br.edu.ufcg.ccc.daca.backend.auth.role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}