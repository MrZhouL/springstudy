package myproject.hello;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by zhoulei on 2017/9/29.
 * 这是存储库接口，这将由Spring自动实现，具有与更改大小写相同名称的bean。bean名称将是 userRepository
 * CRUD refers Create, Read, Update, Delete
 */
public interface UserRepository extends CrudRepository<UserHello,Long>{
}
