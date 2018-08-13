package com.chaka.demo.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaka.demo.HelloProperties;

@RestController
public class HomeController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private HelloProperties helloProperties;

	@GetMapping("/")
	public String Hello() {
		return String.format("%s, %s!", helloProperties.getPrefix(), helloProperties.getTarget());
	}
}
