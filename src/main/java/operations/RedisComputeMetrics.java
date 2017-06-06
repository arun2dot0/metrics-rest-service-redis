package operations;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RedisComputeMetrics implements ComputeMetrics{

	private String key ;
	private ListOperations<String, Integer> listOps;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ListOperations<String, Integer> getListOps() {
		return listOps;
	}

	public void setListOps(ListOperations<String, Integer> listOps) {
		this.listOps = listOps;
	}

	@Override
	public OptionalInt getCurrentValue() {
		OptionalInt currentValue = OptionalInt.empty();
		long size = listOps.size(key);
		if( size >0)	
		{
			currentValue = OptionalInt.of(listOps.range(key,0, 1).get(0).intValue());
		}
		return currentValue;
	}

	private OptionalDouble computeAverage(final ListOperations<String,Integer> listOps,final String key  ,  final int range)
	{
	   
		return  listOps.range(key, 0, range)
				   .stream()
				   .mapToInt(e->e)
				   .average();
				   
		
	}
	
	
	@Override
	public OptionalInt getAverageValue() {
		OptionalInt currentTemp = OptionalInt.empty();
		long size = listOps.size(key);
		if (size > 0) {
			OptionalDouble optAverage = OptionalDouble.empty();
			if (size > averageRatingsLimit) // just do average for last 4
			{
				optAverage = computeAverage(listOps, key, averageRatingsLimit);
			} else
				optAverage = computeAverage(listOps, key, (int) size);

			if (optAverage.isPresent()) {
				Double avgDouble = optAverage.getAsDouble();
				currentTemp = OptionalInt.of(avgDouble.intValue()); // use int for display
			}

		}
		return currentTemp;
	}

	@Override
	public void addMetricValue(int value) {
		listOps.leftPush(key, value);
		listOps.trim(key, 0,10);
	}

}
