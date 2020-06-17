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
public class Product  implements Serializable {
    private Integer pid;
    private Integer wid;
    private String pname;
    private String coding;
    private String model;
    private String bomname;

}
