package com.pino.dao;

import com.pino.entity.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yin on 2018/12/21.
 * Description:
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
