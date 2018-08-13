package com.chaka.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hello", ignoreUnknownFields = false)
public class HelloProperties {

	/**
	 * Prefix welcome message
	 */
	private String prefix;

	/**
	 * Target welcom message
	 */
	private String target;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}
