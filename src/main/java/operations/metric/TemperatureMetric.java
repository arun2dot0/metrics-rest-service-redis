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
public class TemperatureMetric extends MetricIntStrategy implements ComputeMetrics {

	private static final String tempKey = "temp";
	
	@Resource(name = "redisTemplate")
	private ListOperations<String, Integer> listOpsTemp;
	
	@Autowired
	RedisComputeMetrics redisComputeMetrics;
	
	@PostConstruct
	public void init()
	{
		redisComputeMetrics.setKey(tempKey);
		redisComputeMetrics.setListOps(listOpsTemp);
		super.setComputeMetric(redisComputeMetrics);
	}

	

}
