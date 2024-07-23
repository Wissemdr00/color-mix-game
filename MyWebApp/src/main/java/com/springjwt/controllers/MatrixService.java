package com.springjwt.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjwt.entities.Matrix;
import com.springjwt.repositories.MatrixRepository;

@Service
public class MatrixService {
    @Autowired
    private MatrixRepository matrixRepository;

    public List<Matrix> getMatricesByUserId(Integer userId) {
        return matrixRepository.findByUseridOrderByidAsc(userId);  
    }

    public void deleteMatrix(Integer matrixId) {
        matrixRepository.deleteById(matrixId.longValue());
    }

    public Matrix updateMatrix(Integer matrixId, String[][] datam) {
        Optional<Matrix> optionalMatrix = matrixRepository.findById(matrixId.longValue());
        Matrix existingMatrix = optionalMatrix.orElse(null);
        if (existingMatrix != null) {
            existingMatrix.setData(datam);
            // Update other fields as needed
            return matrixRepository.save(existingMatrix);
        } else {
            return null;
        }
    }
    public Matrix createMatrix(Integer userId) {
        Matrix newMatrix = new Matrix();
        newMatrix.setData(new String[][]{{"white"}});
        newMatrix.setUserid(userId);
        return matrixRepository.save(newMatrix);
    }

}