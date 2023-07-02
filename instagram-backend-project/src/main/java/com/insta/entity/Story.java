package com.insta.entity;

import java.util.Objects;

import com.insta.dto.UserDTO;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stories")
public class Story {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "user_id")),
			@AttributeOverride(name = "email", column = @Column(name = "user_email")) })
	private UserDTO userDTO;
	@Column(insertable=false, updatable=false)
	private String image;

	private String caption;

	private String timestamp;

	public Story() {
		
	}

	public Story(Integer id, UserDTO userDTO, String image, String caption, String timestamp) {
		super();
		this.id = id;
		this.userDTO = userDTO;
		this.image = image;
		this.caption = caption;
		this.timestamp = timestamp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(caption, id, image, timestamp, userDTO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Story other = (Story) obj;
		return Objects.equals(caption, other.caption) && Objects.equals(id, other.id)
				&& Objects.equals(image, other.image) && Objects.equals(timestamp, other.timestamp)
				&& Objects.equals(userDTO, other.userDTO);
	}
	

}
