package myproject.exceptionexample.dao;

import myproject.exceptionexample.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhoulei on 2017/10/1.
 */
@Repository
public interface IUserRepository extends JpaRepository<User,Integer>{
}
