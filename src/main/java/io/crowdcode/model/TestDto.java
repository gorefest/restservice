package io.crowdcode.model;

import java.io.Serializable;

/**
 * Created by marcus on 20.03.2017.
 */
public class TestDto implements Serializable{

	private Long timestamp;
	private String message;

	public TestDto(){
	}

	public TestDto(Long timestamp, String message) {

		this.timestamp = timestamp;
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
