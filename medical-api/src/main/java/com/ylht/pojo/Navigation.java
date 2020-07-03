package com.ylht.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class Navigation  implements Serializable {
    private Integer nid;
    private String title;
    private String href;
    private Integer fatherid;
    private List<Navigation> child;
}
