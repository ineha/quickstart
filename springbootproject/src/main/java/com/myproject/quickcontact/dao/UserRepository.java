package com.myproject.quickcontact.dao;

import com.myproject.quickcontact.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
