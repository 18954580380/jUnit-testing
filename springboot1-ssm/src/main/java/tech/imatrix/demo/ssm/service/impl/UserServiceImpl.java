package tech.imatrix.demo.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.imatrix.demo.ssm.dao.UserMapper;
import tech.imatrix.demo.ssm.domain.User;
import tech.imatrix.demo.ssm.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveUser(User user) {
        if(user.getId()!=null){
            userMapper.updateByPrimaryKey(user);
        }else{
            userMapper.insert(user);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> listByPage() {
        return userMapper.selectAll();
    }
}
