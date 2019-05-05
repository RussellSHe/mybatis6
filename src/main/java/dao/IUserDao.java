package dao;

import domain.user;



import java.util.List;

/**
 * @ProjectName: mybatis1
 * @Package: dao
 * @ClassName: IUserDao
 * @Description:
 * @Author: zengyanbo
 * @CreateDate: 2019-04-28 18:06
 * @UpdateDate: 2019-04-28 18:06
 * @Version: 1.0
 */

public interface IUserDao {
 //@Select("select * from user")
    List<user> findAll();
    user findUserById(int id);

    List<user> findUserByName(String name);

    List<user> findUserByCondition(user u);

}
