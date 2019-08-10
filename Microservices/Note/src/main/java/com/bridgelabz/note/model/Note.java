package com.bridgelabz.note.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
public class Note implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String noteId;
	private String userId;
	private String title;
	private String description;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
	private boolean isTrash;
	private boolean isArchive;
	private boolean isPin;
	private String colorCode;

	public Note() {

	}

	public Note(String noteId, String userId, String title, String description, LocalDateTime createTime,
			LocalDateTime updateTime, boolean isTrash, boolean isArchive, boolean isPin, String colorCode) {
		super();
		this.noteId = noteId;
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isTrash = isTrash;
		this.isArchive = isArchive;
		this.isPin = isPin;
		this.colorCode = colorCode;
	}

	public String getNoteId() {
		return noteId;
	}

	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public boolean isTrash() {
		return isTrash;
	}

	public void setTrash(boolean isTrash) {
		this.isTrash = isTrash;
	}

	public boolean isArchive() {
		return isArchive;
	}

	public void setArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}

	public boolean isPin() {
		return isPin;
	}

	public void setPin(boolean isPin) {
		this.isPin = isPin;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", userId=" + userId + ", title=" + title + ", description=" + description
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", isTrash=" + isTrash + ", isArchive="
				+ isArchive + ", isPin=" + isPin + ", colorCode=" + colorCode + "]";
	}

}
