package operations;

import java.util.OptionalInt;

public interface ComputeMetrics {
	
	public static final int averageRatingsLimit =4;
	public OptionalInt getCurrentValue();
	
	public OptionalInt getAverageValue();
	
	public void addMetricValue(int value);
	
}
