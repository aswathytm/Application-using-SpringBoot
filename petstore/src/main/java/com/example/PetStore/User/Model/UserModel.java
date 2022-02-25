package com.example.PetStore.User.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
@Data
@NoArgsConstructor

public class UserModel implements UserDetails {

    @Id
    @SequenceGenerator(

            name="user_seq",
            sequenceName="user_seq",
            allocationSize=1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="user_seq"
    )
    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
    private int userStatus;

    public UserModel(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public UserModel(String userName, String firstName, String lastName, String password, String email, String phone, int userStatus) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    public UserModel(UserModel userModel) {
        this.id = userModel.getId();
        this.userName = userModel.getUsername();
        this.password = userModel.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }
@JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
@JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
@JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
@JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
