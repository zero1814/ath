package org.module.model.commons.db;

import org.module.model.BaseModel;

public class CmDatabase extends BaseModel {

	private String name;

	private String enName;

	private String url;

	private String username;

	private String password;

	private Integer initialSize;

	private Integer maxActive;

	private Integer minIdle;

	private Integer maxWait;

	private Integer testOnBorrow;

	private Integer testOnReturn;

	private Integer testWhileIdle;

	private Integer timeBetweenEvictionRunsMillis;

	private Integer minEvictableIdleTimeMillis;

	private Integer removeAbandoned;

	private Integer removeAbandonedTimeout;

	private Integer logAbandoned;

	private String filters;

	private String desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(Integer initialSize) {
		this.initialSize = initialSize;
	}

	public Integer getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(Integer maxActive) {
		this.maxActive = maxActive;
	}

	public Integer getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(Integer minIdle) {
		this.minIdle = minIdle;
	}

	public Integer getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(Integer maxWait) {
		this.maxWait = maxWait;
	}

	public Integer getTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(Integer testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public Integer getTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(Integer testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public Integer getTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(Integer testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public Integer getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(Integer timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public Integer getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(Integer minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public Integer getRemoveAbandoned() {
		return removeAbandoned;
	}

	public void setRemoveAbandoned(Integer removeAbandoned) {
		this.removeAbandoned = removeAbandoned;
	}

	public Integer getRemoveAbandonedTimeout() {
		return removeAbandonedTimeout;
	}

	public void setRemoveAbandonedTimeout(Integer removeAbandonedTimeout) {
		this.removeAbandonedTimeout = removeAbandonedTimeout;
	}

	public Integer getLogAbandoned() {
		return logAbandoned;
	}

	public void setLogAbandoned(Integer logAbandoned) {
		this.logAbandoned = logAbandoned;
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}