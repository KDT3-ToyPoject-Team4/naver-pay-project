package org.toyproject.DAO;

import org.toyproject.entity.UserEntity;

public interface IUserDAO {
    UserEntity select(String userId);
}
