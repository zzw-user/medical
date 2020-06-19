package com.ylht.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class Role  implements Serializable {
    @Id
    private Integer rid;
    private String rname;
    private String jurisdiction;
    private Integer hierarchy;
}
