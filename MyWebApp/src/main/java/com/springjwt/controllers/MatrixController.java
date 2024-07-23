package com.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjwt.entities.Matrix;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/matrices")
public class MatrixController {
    @Autowired
    private MatrixService matrixService;
    
    @GetMapping("/user/{userId}")
    
    public List<Matrix> getMatricesByUserId(@PathVariable Integer userId) {
        return matrixService.getMatricesByUserId(userId);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{matrixId}")
    public void deleteMatrix(@PathVariable Integer matrixId) {
        matrixService.deleteMatrix(matrixId);
    }
    
    @PutMapping("/{matrixId}")
    public Matrix updateMatrix(@PathVariable Integer matrixId, @RequestBody String[][] matrix) {
        return matrixService.updateMatrix(matrixId, matrix);
    }

    @PostMapping
    public Matrix createMatrix(@RequestBody Integer userId) {
        return matrixService.createMatrix(userId);
    }
}