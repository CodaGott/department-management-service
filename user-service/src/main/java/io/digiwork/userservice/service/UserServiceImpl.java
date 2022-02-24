package io.digiwork.userservice.service;

import io.digiwork.userservice.VO.Department;
import io.digiwork.userservice.VO.ResponseTemplate;
import io.digiwork.userservice.model.User;
import io.digiwork.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User createUser(User user) {
        log.info("Create user service");
        return userRepository.save(user);
    }

    @Override
    public ResponseTemplate getUserWithDepartment(Long userid) {
        log.info("Getting user and department user service");
        ResponseTemplate rt = new ResponseTemplate();
        User user = userRepository.findByUserId(userid);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" + user.getDepartmentId()
                        ,Department.class);
        rt.setUser(user);
        rt.setDepartment(department);
        return rt;
    }
}
