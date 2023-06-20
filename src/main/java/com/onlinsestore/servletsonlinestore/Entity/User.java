package com.onlinsestore.servletsonlinestore.Entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String creationOn;
    private String lastLogin;
}
