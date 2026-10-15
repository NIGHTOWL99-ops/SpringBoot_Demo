package com.example.demo.stress;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PgenatinRepository extends JpaRepository<IPOUser,Long>{

}
