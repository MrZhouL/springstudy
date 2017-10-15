package myproject.hello;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by zhoulei on 2017/9/29.
 * 使用jpa访问数据库实体类。客户类
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    /*@ManyToOne(cascade = CascadeType.ALL)
    private Set<Person> personSet;*/

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
