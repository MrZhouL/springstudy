package myproject.hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by zhoulei on 2017/9/29.
 */
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    /**
     * Spring数据JPA还允许您通过简单地声明其方法签名来定义其他查询方法
     * @param lastName
     * @return
     */
    List<Customer> findByLastName(String lastName);
}
