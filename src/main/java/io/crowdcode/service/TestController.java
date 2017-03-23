package io.crowdcode.service;

import io.crowdcode.model.TestDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by marcus on 20.03.2017.
 */
@RestController
@EnableSwagger2
public class TestController {

	Logger log = LoggerFactory.getLogger(TestController.class);

	@ApiOperation(value = "Gibt Stammdaten zu Aufrufendem zurück.", nickname = "getStammdaten", httpMethod = "GET", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = TestDto.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(path = "/v1/test",	 method = RequestMethod.GET)
	public ResponseEntity<TestDto> getTestDto(
			@ApiParam("Der Name, welcher abgefragt werden soll")
			@RequestParam(required = false, name = "name") String name){
		TestDto result = new TestDto(System.currentTimeMillis(), name + " wurde abgefragt.");
		log.info("SERVICE CALLED WITH PARAMATER "+name);
		return new ResponseEntity<TestDto>(result, HttpStatus.OK);
	}

}
