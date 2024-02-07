package fr.sncf.d2d.colibri.common.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ApplicationErrorController {
    // @RequestMapping(path = "/error")
	public Map<String, Object> handle(HttpServletRequest request) {
		final var map = new HashMap<String, Object>();
		map.put("status", request.getAttribute("jakarta.servlet.error.status_code"));
		map.put("reason", request.getAttribute("jakarta.servlet.error.message"));
		return map;
	}
}
