package ru.vstu.CodeForce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vstu.CodeForce.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
