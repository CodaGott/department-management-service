package io.digiwork.userservice.service;

import io.digiwork.userservice.VO.ResponseTemplate;
import io.digiwork.userservice.model.User;

public interface UserService {
    User createUser(User user);
    ResponseTemplate getUserWithDepartment(Long userid);
}
