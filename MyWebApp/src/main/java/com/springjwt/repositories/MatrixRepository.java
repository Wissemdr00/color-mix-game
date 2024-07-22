package com.springjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjwt.entities.Matrix;

public interface MatrixRepository extends JpaRepository<Matrix, Long> {
}
