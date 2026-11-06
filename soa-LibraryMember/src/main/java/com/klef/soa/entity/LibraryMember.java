package com.klef.soa.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="librarymember_table")
public class LibraryMember
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long libraryMemberId;
	@Column(name = "member_name",length = 100,nullable = false)
	private String name;
	@Column(name = "member_type",length = 50,nullable = false)
	private String type;
	 @Column(name = "member_status", length = 20, nullable = false)
	private String status;
	 @Column(name = "member_location", length = 100, nullable = false)
	private String location;
	 @CreationTimestamp
	 @Column(name = "created_at", nullable = false, updatable = false)
	 private LocalDateTime createdAt;

	 @UpdateTimestamp
	 @Column(name = "updated_at")
	 private LocalDateTime updatedAt;
	public Long getLibraryMemberId() {
		return libraryMemberId;
	}
	public void setLibraryMemberId(Long libraryMemberId) {
		this.libraryMemberId = libraryMemberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "LibraryMember [libraryMemberId=" + libraryMemberId + ", name=" + name + ", type=" + type + ", status="
				+ status + ", location=" + location + "]";
	}
	
	

}
