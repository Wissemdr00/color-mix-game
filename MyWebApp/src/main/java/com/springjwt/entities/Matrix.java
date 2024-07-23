package com.springjwt.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "matrices")
public class Matrix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String data;

    public String[][] getData() {
        String[] rows = data.split("\n");
        String[][] matrix = new String[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = rows[i].trim(); // remove leading and trailing whitespaces
            if (rows[i].startsWith("[")) {
                rows[i] = rows[i].substring(1); // remove the leading "["
            }
            if (rows[i].endsWith("]")) {
                rows[i] = rows[i].substring(0, rows[i].length() - 1); // remove the trailing "]"
            }
            matrix[i] = rows[i].split(", ");
        }
        return matrix;
    }

    public void setData(String[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (String[] row : matrix) {
            sb.append("[");
            for (String element : row) {
                sb.append(element).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()); // remove the last ", "
            sb.append("]\n");
        }
        this.data = sb.toString();
    }


    private Integer userid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer user_id) {
        this.userid = user_id;
    }

    
}