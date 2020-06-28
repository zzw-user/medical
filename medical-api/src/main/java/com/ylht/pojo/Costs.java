package com.ylht.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class Costs implements Serializable {
    private Integer cid;
    private Integer operator;
    private String address;
    private String cost;
    private String sparepartcost;
    private String dataentryclerk;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date inputtime;
    private Integer aftertype;
    private String coding;
    private String phone;
    private String mname;
    private String pname;
}
