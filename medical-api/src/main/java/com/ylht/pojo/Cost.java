package com.ylht.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class Cost  implements Serializable {
    @Id
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
    private String longitude;
    private String latitude;

    private String coding;
    private String phone;
    private String longitude;
    private String latitude;
    @Transient
    private String realname;
    @Transient
    private String pname;
}
