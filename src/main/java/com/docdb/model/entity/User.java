package com.docdb.model.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.docdb.model.entity.base.BaseEntity;
import com.docdb.model.enumerated.UserRole;

@SuppressWarnings("serial")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity implements UserDetails {
	
	private String name;
	
	private String surname;
	
	private Integer age;
	
	private Boolean enableAccount;
	
	@CreatedDate
	private LocalDateTime createTime;
	
	@UpdateTimestamp
	private LocalDateTime updateTime;
	
	private LocalDateTime deleteTime;
	
	private LocalDateTime lastPasswordChange;
	
	private LocalDateTime nextPasswordChange;

	@Column(unique = true, nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String email;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private Set<UserRole> roles;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
	private Customer customer;
	
	public User() {
		super();
		this.customer = new Customer();
		this.setEnableAccount(true);
		this.roles = new HashSet<UserRole>();
		this.roles.add(UserRole.USER);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(ur -> new SimpleGrantedAuthority("ROLE_"+ur.name())).collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.deleteTime.isBefore(LocalDateTime.now());
	}

	@Override
	public boolean isAccountNonLocked() {

		return this.enableAccount;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return (this.lastPasswordChange.isBefore(this.nextPasswordChange));
	}

	@Override
	public boolean isEnabled() {
		return this.enableAccount;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public LocalDateTime getDeleteTime() {
		return deleteTime;
	}

	public void deleteAccount() {
		this.deleteTime = LocalDateTime.now();
	}

	public LocalDateTime getLastPasswordChange() {
		return this.lastPasswordChange;
	}

	private void setLastPasswordChange() {
		this.lastPasswordChange = LocalDateTime.now();
	}

	public LocalDateTime getNextPasswordChange() {
		return nextPasswordChange;
	}

	private void setNextPasswordChange() {
		this.nextPasswordChange = LocalDateTime.now().plusMonths(3L);
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.setLastPasswordChange();
		this.setNextPasswordChange();
		this.password = password;
	}

	public void setEnableAccount(Boolean enableAccount) {
		this.enableAccount = enableAccount;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}	
	
}
