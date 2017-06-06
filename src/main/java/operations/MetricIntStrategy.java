package operations;

import java.util.OptionalInt;


public abstract class MetricIntStrategy implements ComputeMetrics {

	
	RedisComputeMetrics redisComputeMetrics;
	
	public void setComputeMetric(RedisComputeMetrics redisComputeMetrics)
	{
		this.redisComputeMetrics = redisComputeMetrics;
	}
	
	@Override
	public OptionalInt getCurrentValue() {
		return redisComputeMetrics.getCurrentValue();
	}

	@Override
	public OptionalInt getAverageValue() {
		return redisComputeMetrics.getAverageValue();
	}


	@Override
	public void addMetricValue(int value) {
		redisComputeMetrics.addMetricValue(value);
	}
}
