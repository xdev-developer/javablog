package com.javablog.core.entity;

import java.sql.Timestamp;

public class Article{

	private Integer id;

	private Integer sectionId;
	
	private Section section;

	private String title;

	private String text;

	private String shortText;

	private Timestamp created;
	
	private String author;
	
	private Integer commentsCount = 0;

	public Article() {
	}

	public Article(Integer id, Integer sectionId) {
		this.id = id;
		this.sectionId = sectionId;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Integer getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(Integer commentsCount) {
		this.commentsCount = commentsCount;
	}

	public String getShortText() {
		return shortText;
	}

	public void setShortText(String shortText) {
		this.shortText = shortText;
	}
	
	@Override
	public String toString() {
		return "Article [created=" + created + ", id=" + id + ", sectionId="
				+ sectionId + ", text=" + text + ", title=" + title + "]";
	}

}
