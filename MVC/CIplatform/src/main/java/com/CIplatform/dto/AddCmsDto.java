package com.CIplatform.dto;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class AddCmsDto {
	private String title;
	private Date createdAt;
	private Date deletedAt;
	private Date updatedAt;
	private String description;
	private String slug;
	private com.entities.CmsPage.status status;
	public AddCmsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddCmsDto(String title, Date createdAt, Date deletedAt, Date updatedAt, String description, String slug,
			com.entities.CmsPage.status status) {
		super();
		this.title = title;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
		this.updatedAt = updatedAt;
		this.description = description;
		this.slug = slug;
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public com.entities.CmsPage.status getStatus() {
		return status;
	}
	public void setStatus(com.entities.CmsPage.status status) {
		this.status = status;
	}
	
}
