//Create the Concrete Decorator: 
//Create a class HeavyLoadDecorator that extends your abstract decorator.
//In the calculate method, call the wrapped strategy’s calculation, 
// and then add 15.0 to the result.
public class HeavyLoadDecorator extends ShippingDecorator {
    public HeavyLoadDecorator(ShippingStrategy decoStrategy) {
        super(decoStrategy);
    }

    @Override
    public double calculate(double weight, double distance) {
        return decoStrategy.calculate(weight, distance) + 15;
    }
}
