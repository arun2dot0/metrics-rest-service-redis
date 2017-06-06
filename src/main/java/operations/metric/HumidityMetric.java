package operations.metric;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Component;

import operations.ComputeMetrics;
import operations.MetricIntStrategy;
import operations.RedisComputeMetrics;
@Component
public class HumidityMetric extends MetricIntStrategy implements ComputeMetrics{
	private static final String key = "humidity";
	
	@Resource(name = "redisTemplate")
	private ListOperations<String, Integer> listOpsHumidity;
	
	@Autowired
	RedisComputeMetrics redisComputeMetrics;
	
	@PostConstruct
	public void init()
	{
		redisComputeMetrics.setKey(key);
		redisComputeMetrics.setListOps(listOpsHumidity);
		super.setComputeMetric(redisComputeMetrics);
	}

}
