package myproject.exceptionexample.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zhoulei on 2017/10/1.
 */
@Entity
//@Data
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String userName;//姓名
    private String password;//密码
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
    private List<Address> addresses;
}
