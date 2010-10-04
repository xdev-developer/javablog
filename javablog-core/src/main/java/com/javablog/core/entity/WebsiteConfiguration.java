package com.javablog.core.entity;

public class WebsiteConfiguration {
	
	private Integer id;
	
	private String configurationSet;
	
	private String defaultArticleAuthor;
	
	private String adminEmail;
	
	private String mailSmtpHost;
	
	private String mailSenderAddress;
	
	public WebsiteConfiguration() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConfigurationSet() {
		return configurationSet;
	}

	public void setConfigurationSet(String configurationSet) {
		this.configurationSet = configurationSet;
	}
	
	public String getDefaultArticleAuthor() {
		return defaultArticleAuthor;
	}

	public void setDefaultArticleAuthor(String defaultArticleAuthor) {
		this.defaultArticleAuthor = defaultArticleAuthor;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getMailSmtpHost() {
		return mailSmtpHost;
	}

	public void setMailSmtpHost(String mailSmtpHost) {
		this.mailSmtpHost = mailSmtpHost;
	}

	public String getMailSenderAddress() {
		return mailSenderAddress;
	}

	public void setMailSenderAddress(String mailSenderAddress) {
		this.mailSenderAddress = mailSenderAddress;
	}
}
