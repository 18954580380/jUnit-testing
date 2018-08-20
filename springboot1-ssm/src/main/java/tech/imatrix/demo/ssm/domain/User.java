package tech.imatrix.demo.ssm.domain;

import javax.persistence.*;

@Table(name = "ssm_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    private String name;

    @Column(name = "loginName")
    private String loginname;

    private String password;

    public User(){}
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return loginName
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * @param loginname
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}