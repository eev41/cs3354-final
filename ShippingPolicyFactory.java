public class ShippingPolicyFactory {
	public static getStrategy createStrategy(String type) {
		if (type.equalsIgnoreCase("Flat Rate"))
			return new FlatRateStrategy();
		if (type.equalsIgnoreCase("Weight-based"))
			return new WeightBasedStrategy();
		if (type.equalsIgnoreCase("Distance-based"))
			return new DistanceBasedStrategy();
		if (type.equalsIgnoreCase("Carrier-Specific"))
			return new CarrierSpecificStrategy();
		return null;
	}
}