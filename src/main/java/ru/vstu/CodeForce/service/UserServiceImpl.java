package ru.vstu.CodeForce.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vstu.CodeForce.exception.ResourceNotFoundException;
import ru.vstu.CodeForce.dto.UserDTO;
import ru.vstu.CodeForce.model.User;
import ru.vstu.CodeForce.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    public User userDTOoUser(UserDTO userDTO) {
        User user = new User();
        user.setAvatar(userDTO.getAvatar());
        user.setCity(userDTO.getCity());
        user.setContribution(userDTO.getContribution());
        user.setEmail(userDTO.getEmail());
        user.setHandle(userDTO.getHandle());
        user.setCountry(userDTO.getCountry());
        user.setFirstName(userDTO.getFirstName());
        user.setRank(userDTO.getRank());
        user.setFriendOfCount(userDTO.getFriendOfCount());
        user.setLastName(userDTO.getLastName());
        user.setLastOnlineTimeSeconds(userDTO.getLastOnlineTimeSeconds());
        user.setMaxRank(userDTO.getMaxRank());
        user.setMaxRating(userDTO.getMaxRating());
        user.setRank(userDTO.getRank());
        user.setOrganization(userDTO.getOrganization());
        user.setTitlePhoto(userDTO.getTitlePhoto());
        user.setVkId(userDTO.getVkId());
        return user;
    }
}
