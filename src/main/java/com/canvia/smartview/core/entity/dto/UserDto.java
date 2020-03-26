package com.canvia.smartview.core.entity.dto;

import java.util.List;

public class UserDto {

    private Long userId;
    private String username;
    private String password;
    private List<RoleDto> roles;
    private List<CompanyConfigDto> companies;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public List<CompanyConfigDto> getCompanies() {
        return companies;
    }

    public void setCompanies(List<CompanyConfigDto> companies) {
        this.companies = companies;
    }
}
