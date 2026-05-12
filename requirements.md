# Final exam instructions

Complete the following changes in the design of the application

## Part A: Implementing the Strategy Pattern

Objective: Move the hardcoded shipping formulas out of the ActionListener and into interchangeable "Strategy" classes.

Define the Interface: Create an interface named ShippingStrategy with a single method: double calculate(double weight, double distance).

Create Concrete Strategies: Create four classes that implement this interface: FlatRateStrategy, WeightBasedStrategy, DistanceBasedStrategy, and CarrierSpecificStrategy.

Encapsulate Logic: Move the specific math formulas from the original if-else blocks into the calculate methods of these new classes.

Verification: Ensure that each strategy class is independent and does not reference any Swing components (like JTextField).

## Part B: Implementing the Factory Method

Objective: Centralize the logic that decides which shipping policy to use based on the user's selection.

Create the Factory: Create a class named ShippingPolicyFactory.

Logic Separation: Define a static method (e.g., getStrategy(String type)) that takes the String from the JComboBox as an input and returns the appropriate ShippingStrategy object.

Refactor the UI: Modify the ActionListener in the main GUI class. Instead of using a long if-else block to calculate costs, call the Factory to get a strategy and then execute its calculate method.

Goal: The GUI should now only know it is receiving a "Strategy"—it should not know which specific concrete class it is using.

## Part C: Implementing the Decorator Pattern

Objective: Dynamically add a "Heavy Load Surcharge" without modifying the existing strategy classes.

Create the Abstract Decorator: Create an abstract class ShippingDecorator that implements ShippingStrategy. It should hold a private reference to a ShippingStrategy (the object it is wrapping).

Create the Concrete Decorator: Create a class HeavyLoadDecorator that extends your abstract decorator.

In the calculate method, call the wrapped strategy’s calculation and then add 15.0 to the result.

Integrate with the Factory: Update your ShippingPolicyFactory logic.

First, create the base strategy requested by the user.

Then, add a check: if the weight provided exceeds 20kg, wrap that base strategy inside a HeavyLoadDecorator before returning it.

Final Result: The calculation should now look like a recursive call: Decorator.calculate() -> Strategy.calculate().

## Important Implementation Constraints

To receive full credit, your refactored solution must adhere to the following strict constraints:

### 1. GUI Preservation (Structural Integrity)

The "Look and Feel" Rule: You are strictly prohibited from changing the layout, size, or appearance of the Swing components. The JFrame structure, JPanel layout, and component names (e.g., weightField, policyCombo) must remain exactly as they are in the original code.

Component Usage: Do not add new buttons, checkboxes, or menu items. Your design patterns must work "under the hood" using the inputs already provided.

The "Zero UI Change" Test: If a user runs your new version next to the original version, they should not be able to tell which is which based on the visual interface alone.

### 2. Functional Parity (Black-Box Testing)
Consistency of Results: The mathematical output for every combination of input must remain identical to the original version.

Example: If a 25kg package with "Flat Rate" resulted in $35.0 ($20 base + $15 heavy surcharge) in the original version, your refactored code must produce the exact same result.

Expected Behavior: The application must still respond to the "Calculate Cost" button and display results in the resultArea in the same format. You are changing how the program thinks, not what it thinks.

Edge Cases: Ensure your new Strategy and Decorator classes handle invalid inputs (like letters in the weight field) with the same grace (or error dialogs) as the original monolithic version.

## Pro-Tip for Students:

Think of this as a "Brain Transplant." You are removing the messy, tangled logic from the body of the GUI and replacing it with a sophisticated, modular brain (the Patterns). The body (the GUI) should stay exactly the same, but it will be much easier to upgrade in the future!