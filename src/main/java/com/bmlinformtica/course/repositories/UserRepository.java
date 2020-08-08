package com.bmlinformtica.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmlinformtica.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
