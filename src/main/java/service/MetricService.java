package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Metric;
import operations.metric.HumidityMetric;
import operations.metric.LightIntensityMetric;
import operations.metric.SoundIntensityMetric;
import operations.metric.TemperatureMetric;

@Component
public class MetricService {

	@Autowired
	TemperatureMetric tempMetric;

	@Autowired
	HumidityMetric humidityMetric;

	@Autowired
	LightIntensityMetric lightIntensityMetric;

	@Autowired
	SoundIntensityMetric soundIntensityMetric;

	public void addMetrics(Metric metric) {
		tempMetric.addMetricValue(metric.getTemperature());
		humidityMetric.addMetricValue(metric.getHumidity());
		lightIntensityMetric.addMetricValue(metric.getLightintensity());
		soundIntensityMetric.addMetricValue(metric.getSoundIntensity());
	}

	public Metric getCurrentMetric() {
		return new Metric(tempMetric.getCurrentValue().getAsInt(), humidityMetric.getCurrentValue().getAsInt(),
				lightIntensityMetric.getCurrentValue().getAsInt(), soundIntensityMetric.getCurrentValue().getAsInt());

	}
	
	public Metric getAverageMetric() {
		return new Metric(tempMetric.getAverageValue().getAsInt(), humidityMetric.getAverageValue().getAsInt(),
				lightIntensityMetric.getAverageValue().getAsInt(), soundIntensityMetric.getAverageValue().getAsInt());

	}
}
