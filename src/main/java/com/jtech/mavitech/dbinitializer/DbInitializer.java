package com.blockchain.ehealthservice.dbinitializer;

import com.blockchain.ehealthservice.entity.ERole;
import com.blockchain.ehealthservice.entity.Role;
import com.blockchain.ehealthservice.entity.User;
import com.blockchain.ehealthservice.repository.RoleRepository;
import com.blockchain.ehealthservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public DbInitializer(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // ---------- creation des user type ------------

        Role rolesSys = new Role();
        rolesSys.setId(1);
        rolesSys.setName(ERole.ROLE_ADMIN);

        Optional<Role> rolesS = this.roleRepository.findById(1);
        if (rolesS.isEmpty()){
            this.roleRepository.save(rolesSys);
        }

        Role rolesMed = new Role();
        rolesMed.setId(2);
        rolesMed.setName(ERole.ROLE_MEDECIN);

        Optional<Role> rolesD = this.roleRepository.findById(2);
        if (rolesD.isEmpty()){
            this.roleRepository.save(rolesMed);
        }

        Role rolesUser = new Role();
        rolesUser.setId(3);
        rolesUser.setName(ERole.ROLE_USER);

        Optional<Role> rolesC = this.roleRepository.findById(3);
        if (rolesC.isEmpty()){
            this.roleRepository.save(rolesUser);
        }

        User userSys = new User();
        userSys.setNom("sysadmin");
        userSys.setUsername("@sysadmin");
        userSys.setPrenom("sysadmin");
        userSys.setEmail("sysadmin@gmail.com");
        userSys.setTel("91596602");
        userSys.setFonction("Super Admin");
        userSys.setNationalite("Togolaise");
        userSys.setPassword(passwordEncoder.encode("@sys@#123"));
        userSys.setRoles(Collections.singleton(rolesSys));

        if (!this.userRepository.findByUsername("@sysadmin").isPresent()){
            this.userRepository.save(userSys);
        }

        System.out.println(" -- Database has been initialized");

    }

}