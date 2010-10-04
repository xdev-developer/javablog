package com.javablog.core.entity;

import java.util.List;

/**
 * Section Entity 
 * @author xdev
 *
 * @param <AbstractID>
 */
public class Section {
	
	private Integer id;// section id
	
	private String name;// section name
	
	private String url;
	
	private Integer articlesCount = 0;
	
	private List<Article> articles;
	
	public Section() {}
	
	/**
	 * Create new section
	 * @param id - section id
	 * @param name - section name
	 */
	public Section(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Integer getArticlesCount() {
		return articlesCount;
	}

	public void setArticlesCount(Integer articlesCount) {
		this.articlesCount = articlesCount;
	}
	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Section [articles=" + articles + ", articlesCount="
				+ articlesCount + ", id=" + id + ", name=" + name + ", url="
				+ url + "]";
	}
}
