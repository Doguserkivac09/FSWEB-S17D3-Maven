package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kangaroo {

    private int id;
    private String name;
    private Double height;
    private Double weight;
    private String gender;
    private Boolean aggressive;

    public Boolean getIsAggressive() {
        return aggressive;
    }

    public void setIsAggressive(Boolean isAggressive) {
        this.aggressive = isAggressive;
    }
}

