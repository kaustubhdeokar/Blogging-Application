package com.example.reddit.repo;

import com.example.reddit.model.Role;
import com.example.reddit.model.Topic;
import com.example.reddit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<List<Object[]>> findRolesByUserid(Long userid);
}
