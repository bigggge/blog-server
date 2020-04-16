package cc.haoduoyu.blog.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户登录表
 */
@Table(name = "user")
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", insertable = false, nullable = false)
    private Integer userid;

    /**
     * ?????
     */
    @Column(name = "username", nullable = false)
    private String username = "";

    /**
     * md5?????
     */
    @Column(name = "password", nullable = false)
    private String password = "";

    /**
     * 用户状态
     */
    @Column(name = "userstatus", nullable = false)
    private Integer userstatus = 1;

    /**
     * 最后修改时间
     */
    @Column(name = "updatetime", nullable = false)
    private Timestamp updatetime;

    /**
     * 邮箱
     */
    @Column(name = "email", nullable = true)
    private String email;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}