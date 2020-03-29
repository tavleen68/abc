package com.DevOps.Capstone.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.DevOps.Capstone.Project.TableDB.FundTransferTB;

public interface FundTransferRepository extends JpaRepository<FundTransferTB, Integer>{

}
