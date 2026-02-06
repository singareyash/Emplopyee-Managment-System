package com.EmplopyeemanagmentByyash.Reposistory;

import com.EmplopyeemanagmentByyash.Entity.Emplopyee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmplopyeeReposistory extends JpaRepository<Emplopyee,Integer> {


}
