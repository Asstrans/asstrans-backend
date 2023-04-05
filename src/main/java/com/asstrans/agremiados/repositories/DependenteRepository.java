package com.asstrans.agremiados.repositories;


import com.asstrans.agremiados.model.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long> {


}
