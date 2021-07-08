package com.elm.UserPortal.UserPortal.Models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private int userID;

    @Column(unique = true, name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "MobileNumber")
    private String mobileNumber;

    @Column(unique = true, name = "Email")
    private String email;

    @Column(name = "Enabled")
    private boolean enabled = true;

    //----------------------------

    @OneToMany(mappedBy = "userPrivileges", cascade = CascadeType.ALL)
    private List<Privilege> privileges = new ArrayList<>();

    public User() {

    }

    public User(int userID, String username, String password, String mobileNumber, String email, boolean enabled, List<Privilege> privileges) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.enabled = enabled;
        this.privileges = privileges;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
