package com.DevOps.Capstone.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DevOps.Capstone.Project.TableDB.LoginTB;

public interface LoginRepository extends JpaRepository<LoginTB, String>
  {

}
