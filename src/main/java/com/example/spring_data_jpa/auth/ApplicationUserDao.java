package com.example.spring_data_jpa.auth;
import java.util.Optional;


public interface ApplicationUserDao {
    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
