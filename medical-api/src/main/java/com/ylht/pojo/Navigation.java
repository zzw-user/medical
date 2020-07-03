package com.ylht.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
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
    @JsonIgnore
    private List<Navigation> children = new ArrayList<Navigation>();
    @JsonIgnore
    private Navigation parent;
    private List<Navigation> child;
}
