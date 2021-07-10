package com.elm.UserPortal.UserPortal.Models;

import javax.persistence.*;

@Entity
@Table(name = "Privileges")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuthorityID")
    private int authorityID;

    @Column(name = "AuthorityName")
    private String authorityName;

    //------------------------

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Username")
    private User userPrivileges;

    public Privilege() {}

    public Privilege(int authorityID, String authorityName, User userPrivileges) {
        this.authorityID = authorityID;
        this.authorityName = authorityName;
        this.userPrivileges = userPrivileges;
    }

    public int getAuthorityID() {
        return authorityID;
    }

    public void setAuthorityID(int authorityID) {
        this.authorityID = authorityID;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public User getUserPrivileges() {
        return userPrivileges;
    }

    public void setUserPrivileges(User userPrivileges) {
        this.userPrivileges = userPrivileges;
    }
}
