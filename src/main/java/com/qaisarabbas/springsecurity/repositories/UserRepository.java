package com.qaisarabbas.springsecurity.repositories;

/*
 * @created 27/08/2023 - 8:29 pm
 * @project springsecurity
 * @package com.qaisarabbas.springsecurity.repositories
 * @author Qaisar Abbas
 */

import com.qaisarabbas.springsecurity.entites.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UsersEntity, Long> {
    Optional<UsersEntity> findByEmail(String email);
}
