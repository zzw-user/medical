package com.ylht.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class Faultanalysis implements Serializable {
    private Integer id;
    private String analyze;
    private Integer faulttype;
    private Integer faultdescription;
    private Integer aid;
}
