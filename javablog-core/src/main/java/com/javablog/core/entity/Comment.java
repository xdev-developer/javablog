package com.javablog.core.entity;

import java.sql.Timestamp;

public class Comment<AbstractID> {
	
	private AbstractID id;
	
	private String text;
	
	private String author;
	
	private Timestamp createdDate;
	
	private Integer articleId;
	
	public Comment() {
	}

	public AbstractID getId() {
		return id;
	}

	public void setId(AbstractID id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" Comment [");
		buffer.append(" id=").append(id);
		buffer.append(" author=").append(author);
		buffer.append(" createdDate=").append(createdDate);
		buffer.append(" text=").append(text);
		buffer.append("]");
		return buffer.toString();
	}
}
