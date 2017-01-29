package com.axatrikx.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.axatrikx.controller.RestExecutor;

public class TestScript {

	private static final String URL = "http://maps.googleapis.com/maps/api/geocode";

	private static RestExecutor executor;

	@BeforeClass
	public static void setUp() {
		/*
		 * Initialize RestExecutor object using the end point URL
		 */
		executor = new RestExecutor(URL);
	}

	@Test
	public void testGETMethod1() {
		/*
		 * Performs GET operation on http://localhost:3000/posts.
		 * Note that we give only the path in the get method as we use 
		 * the domain part while initializing the RestExecutor object
		 */
		executor.get("/json?address=chicago&sensor=false&#8221")
		
		.expectCode(200)			// Expected code of 200
		.expectMessage("OK")
		.expectInBody( "address_components");
		
	}
	@Test
	public void testGETMethod() {
		/*
		 * Performs GET operation on http://localhost:3000/posts.
		 * Note that we give only the path in the get method as we use 
		 * the domain part while initializing the RestExecutor object
		 */
		executor.get("/posts")
			.expectCode(200)			// Expected code of 200
			.expectMessage("OK")
			.expectInBody( "Chicago, IL, USA");
		// Expected Message of 'OK'
					// Yet Another Content inside the response body
		
		/*
		 * GET for a specific item
		 */
		executor.get("/posts/1")
			.expectCode(200)
			.expectMessage("OK")
			.expectHeader("Content-Type", "application/json; charset=utf-8")
			.expectInBody("rest testing framework")
			.expectInBody("axatrikx");
		
		/*
		 * GET for a seach query
		 */
		executor.get("/posts?title=rest%20testing%20framework&author=axatrikx")
			.expectCode(200)
			.expectMessage("OK")
			.expectHeader("Content-Type", "application/json; charset=utf-8")
			.expectInBody("rest testing framework")
			.expectInBody("axatrikx");
	}
	


	@Test
	public void testPOSTMethod() {
		/*
		 * POST operation for insertion providing the path, xml content and content type.
		 */
		executor.post("/posts", "{ \"title\": \"new test\", \"author\": \"axatrikx\" }", "application/json")
			.expectCode(201)
			.expectMessage("Created")
			.expectHeader("Content-Type", "application/json; charset=utf-8")
			.expectInBody("\"title\": \"new test\"")
			.expectInBody("axatrikx");
	}
}
