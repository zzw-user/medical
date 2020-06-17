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
public class Mpuser  implements Serializable {
    private Integer mpid;
    private String mname;
    private String password;
    private String phone;
    private String mailbox;
    private Integer sex;
    private String address;
    private Integer roleid;
    private Integer age;
}
