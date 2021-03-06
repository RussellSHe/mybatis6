import dao.IRoleDao;
import dao.IUserDao;
import domain.role;
import domain.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * User: Russell
 * Date: 2019-05-02
 * Time: 14:25
 */
public class test {
    InputStream in;
    SqlSession sqlSession;
    IUserDao userDao;
    IRoleDao roleDao;

    @Before
    public void init() throws Exception{
        //读取配置文件
         in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建sqlsession工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //创建sqlsession对象
         sqlSession = factory.openSession(true); //开启自动提交事务
        //创建dao接口的代理对象
         userDao = sqlSession.getMapper(IUserDao.class);
         roleDao = sqlSession.getMapper(IRoleDao.class);

    }
    @After
    public void destroy() throws Exception{
        //提交事务
       // sqlSession.commit();

        //释放资源
        sqlSession.close();
        in.close();
    }

    @Test
   public void findAll() {


        //执行方法
        List<user> users = userDao.findAll();
        users.forEach(t-> System.out.println(t+" "+t.getRoles()));

    }

    @Test
    public void findAllRoles() {


        //执行方法
        List<role> roles = roleDao.findAll();
        roles.forEach(t-> System.out.println(t+" "+t.getUsers()));

    }



    @Test
    public void findOne() {

        //执行方法
        user user = userDao.findUserById(46);
        System.out.println(user);

    }

    @Test
    public void findByName() {

        //执行方法
        List<user> users = userDao.findUserByName("%王%");
        users.forEach(System.out::println);

    }


    @Test
    public void findByCon() {

        user user = new user();
        user.setUsername("老王");

       user.setSex("男");
        //执行方法
        List<user> users = userDao.findUserByCondition(user);
        users.forEach(System.out::println);

    }

}
