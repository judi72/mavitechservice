package com.blockchain.ehealthservice.repository;

import com.blockchain.ehealthservice.entity.ERole;
import com.blockchain.ehealthservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);

}
