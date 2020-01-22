package com.mohanty.Modelapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohanty.Modelapp.entity.UserRest;

@Repository
public interface UserRepository extends JpaRepository<UserRest, Integer> {

	

}
