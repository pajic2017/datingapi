package com.paki.dating.datingapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

@Entity
@Table(name = "interest")
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "likes")
    private String likes;
    @Column(name = "dislikes")
    private String dislikes;
    @Column(name = "hobbies")
    private String hobbies;
    @Column(name = "profileUrl")
    private String profileUrl;
    @Column(name = "about")
    private String about;

    @Transient
    private int userAccountId;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserAccount userAccount;

    public Interest() {

    }

    public Interest(String likes, String dislikes, String hobbies, String profileUrl, String about, int userAccountId,
            UserAccount userAccount) {
        this.likes = likes;
        this.dislikes = dislikes;
        this.hobbies = hobbies;
        this.profileUrl = profileUrl;
        this.about = about;
        this.userAccountId = userAccountId;
        this.userAccount = userAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDislikes() {
        return dislikes;
    }

    public void setDislikes(String dislikes) {
        this.dislikes = dislikes;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public int getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }

    @Override
    public String toString() {
        return "Interest [about=" + about + ", dislikes=" + dislikes + ", hobbies=" + hobbies + ", id=" + id
                + ", likes=" + likes + ", profileUrl=" + profileUrl + ", userAccount=" + userAccount
                + ", userAccountId=" + userAccountId + "]";
    }

}
