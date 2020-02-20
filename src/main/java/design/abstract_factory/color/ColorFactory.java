package design.abstract_factory.color;

import design.abstract_factory.AbstractFactory;
import design.abstract_factory.shape.Shape;

public class ColorFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		if (color == null){
			return null;
		}        
		if (color.equalsIgnoreCase("red")) {
			return new Red();
		} else if (color.equalsIgnoreCase("green")) {
			return new Green();
		} else if (color.equalsIgnoreCase("blue")) {
			return new Blue();
		}
		return null;
	}

	@Override
	public Shape getShape(String shape) {
		return null;
	}

}
