package java8_assessments_DateTimeAPI;

import java.time.Duration;

public class BusVariables {
	
	String time;
	Duration frequency;
	public BusVariables(String time, Duration frequency) {
		super();
		this.time = time;
		this.frequency = frequency;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Duration getFrequency() {
		return frequency;
	}
	public void setFrequency(Duration frequency) {
		this.frequency = frequency;
	}
	
	
	

}
