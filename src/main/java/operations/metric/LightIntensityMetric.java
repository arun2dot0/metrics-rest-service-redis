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
public class LightIntensityMetric extends MetricIntStrategy implements ComputeMetrics{
	private static final String key = "light";
	
	@Resource(name = "redisTemplate")
	private ListOperations<String, Integer> listOpsLight;
	
	@Autowired
	RedisComputeMetrics redisComputeMetrics;
	
	@PostConstruct
	public void init()
	{
		redisComputeMetrics.setKey(key);
		redisComputeMetrics.setListOps(listOpsLight);
		super.setComputeMetric(redisComputeMetrics);
	}

	
}