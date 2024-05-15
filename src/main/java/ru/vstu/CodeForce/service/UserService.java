package ru.vstu.CodeForce.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.vstu.CodeForce.dto.UserDTO;
import ru.vstu.CodeForce.model.User;

import java.util.List;

@Service
public interface UserService {
    User getById(Long id);
    List<User> getAll();
    User create(User user);
    User update(Long id, User user);
    void deleteById(Long id);
}
