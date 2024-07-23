package com.springjwt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springjwt.entities.Matrix;

public interface MatrixRepository extends JpaRepository<Matrix, Long> {
   @Query("SELECT m FROM Matrix m WHERE m.userid = :userid ORDER BY m.id ASC")
    List<Matrix> findByUseridOrderByidAsc(@Param("userid") Integer userId);
    Matrix findById(Integer id);
}
