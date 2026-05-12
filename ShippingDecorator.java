//Create the Abstract Decorator: Create an abstract class ShippingDecorator that implements ShippingStrategy. 
//It should hold a private reference to a ShippingStrategy (the object it is wrapping).

public abstract class ShippingDecorator implements ShippingStrategy {
    protected ShippingStrategy decoStrategy;

    public ShippingDecorator(ShippingStrategy decoStrategy) {
        this.decoStrategy = decoStrategy;
    }

    @Override
    public double calculate(double weight, double distance) {
        return decoStrategy.calculate(weight, distance);
    }
}
