package com.endTerm.solution.repository;

import com.endTerm.solution.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserDTO, Integer> {

    public List<UserDTO> findByNameIgnoreCaseContaining(String name);

}
