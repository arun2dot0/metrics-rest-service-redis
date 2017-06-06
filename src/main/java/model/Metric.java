package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Metric implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6978372469196674153L;
	int Temperature;
	int Humidity;
	int Lightintensity;
	int SoundIntensity;
	Calendar timeStamp;
	
	
	public Metric()
	{}
	
	public Metric(int temperature, int humidity, int lightintensity, int soundIntensity) {
		super();
		Temperature = temperature;
		Humidity = humidity;
		Lightintensity = lightintensity;
		SoundIntensity = soundIntensity;
		timeStamp = Calendar.getInstance();
	}
	
	
	@Override
	public String toString() {
		return "Metrics [Temperature=" + Temperature + ", Humidity=" + Humidity + ", Lightintensity=" + Lightintensity
				+ ", SoundIntensity=" + SoundIntensity + ", timeStamp=" + timeStamp + "]";
	}


	public int getTemperature() {
		return Temperature;
	}
	public void setTemperature(int temperature) {
		Temperature = temperature;
	}
	public int getHumidity() {
		return Humidity;
	}
	public void setHumidity(int humidity) {
		Humidity = humidity;
	}
	public int getLightintensity() {
		return Lightintensity;
	}
	public void setLightintensity(int lightintensity) {
		Lightintensity = lightintensity;
	}
	public int getSoundIntensity() {
		return SoundIntensity;
	}
	public void setSoundIntensity(int soundIntensity) {
		SoundIntensity = soundIntensity;
	}
	
	
	public Calendar getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Calendar timeStamp) {
		this.timeStamp = timeStamp;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
