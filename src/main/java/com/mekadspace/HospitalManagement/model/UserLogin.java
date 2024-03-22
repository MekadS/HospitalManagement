package com.mekadspace.HospitalManagement.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.mekadspace.HospitalManagement.config.ConstantUtils;
import com.mekadspace.HospitalManagement.model.masterData.MasterRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_userlogin")
public class UserLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userLoginId;

	@NotBlank
	@NotEmpty
	@Pattern(regexp = ConstantUtils.REGEXP_USERNAME, message = "Invalid Username")
	@Column(length = 50, nullable = false, unique = true)
	private String username;

	@NotBlank
	@NotEmpty
	@Column(length = 100, nullable = false)
	private String password;

	@OneToOne()
	@JoinColumn(name = "roleId")
	public MasterRole role;

	@Column(length = 1, nullable = false)
	private Boolean isActive;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "entrydate", nullable = false)
	private Date entrydate;

	@Transient
	private String captcha;

	@Transient
	private String hiddenCaptcha;

	@Transient
	private String realCaptcha;
}