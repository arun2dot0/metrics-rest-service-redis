package db;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import javax.annotation.Resource;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisResource {
	// inject the actual template
	
//	private static final String tempKey = "temp";
//	private static final String humidityKey = "humidity";
//	private static final String soundIntensityKey = "sound";
//	private static final String lightIntensityKey = "light";
//	
//	private static final int averageRatingsLimit =4;
//	@Autowired
//	private RedisTemplate<String, Integer> template;
//
//	@Resource(name = "redisTemplate")
//	private ListOperations<String, Integer> listOpsTemp;
//	
//	@Resource(name = "redisTemplate")
//	private ListOperations<String, Integer> listOpsHumidity;
//	
//	@Resource(name = "redisTemplate")
//	private ListOperations<String, Integer> listOpsLight;
//	
//	@Resource(name = "redisTemplate")
//	private ListOperations<String, Integer> listOpsSound;
//
//	public OptionalInt getCurrentTemperature()
//	{
//		OptionalInt currentTemp = OptionalInt.empty();
//		long size = listOpsTemp.size(tempKey);
//		if( size >0)	
//		{
//			currentTemp = OptionalInt.of(listOpsTemp.range(tempKey, size-1, size).get(0).intValue());
//		}
//		return currentTemp;
//	}
//	
//	private OptionalDouble computeAverage(final ListOperations<String,Integer> listOps,final String key ,final long size ,  final int range)
//	{
//	   
//		return  listOps.range(key, size-range, size)
//				   .stream()
//				   .mapToInt(e->e)
//				   .average();
//				   
//		
//	}
//	public OptionalInt getAverageTemperature()
//	{
//		OptionalInt currentTemp = OptionalInt.empty();
//		long size = listOpsTemp.size(tempKey);
//		if( size >0)	
//		{
//			if( size > averageRatingsLimit ) // just do average for last 4 
//			{
//				OptionalDouble optAverage =  computeAverage(listOpsTemp,tempKey,size, averageRatingsLimit );
//				if(optAverage.isPresent())
//				{
//					Double avgDouble = optAverage.getAsDouble();
//					currentTemp =OptionalInt.of(avgDouble.intValue()); // int is good for ui
//				}
//			}
//			
//		}
//		return currentTemp;
//	}
	
}


