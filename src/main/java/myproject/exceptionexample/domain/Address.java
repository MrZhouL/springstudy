package myproject.exceptionexample.domain;

import lombok.Data;
import myproject.exceptionexample.domain.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by zhoulei on 2017/10/1.
 */
@Entity
@Data
public class Address {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String province;//省
    @NotNull
    private String city;//市
    @NotNull
    private String county;//区
    private Boolean isDefault;//是否是默认地址

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "uid")
    private User user;
}
