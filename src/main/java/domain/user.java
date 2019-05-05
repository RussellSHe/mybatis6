package domain;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: mybatis1
 * @Package: domain
 * @ClassName: user
 * @Description:
 * @Author: zengyanbo
 * @CreateDate: 2019-04-28 18:03
 * @UpdateDate: 2019-04-28 18:03
 * @Version: 1.0
 */

public class user implements Serializable {
    private int id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    //多对多映射：一个用户有多个角色
    private List<role> roles;

    public List<role> getRoles() {
        return roles;
    }

    public void setRoles(List<role> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                '}';
    }
}
