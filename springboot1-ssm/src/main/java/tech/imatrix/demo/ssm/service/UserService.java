package tech.imatrix.demo.ssm.service;

import tech.imatrix.demo.ssm.domain.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);
    void saveUser(User user);
    void deleteUser(Long id);
    List<User> listByPage();
}
