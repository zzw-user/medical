//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ylht.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class Information {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private Integer isread;
    private String context;
    private String recipient;
    private String sender;
    private String title;
    @DateTimeFormat(
            pattern = "yyyy-MM-dd hh:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd hh:mm:ss"
    )
    private Date sendtime;




}
