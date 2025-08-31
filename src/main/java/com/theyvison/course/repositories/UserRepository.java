package com.theyvison.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theyvison.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
