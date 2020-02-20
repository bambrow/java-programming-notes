package design.factory;

import design.factory.shape.Circle;
import design.factory.shape.Rectangle;
import design.factory.shape.Shape;
import design.factory.shape.Square;

public class ShapeFactory {

	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		factory.getShape("CIRCLE").draw();
		factory.getShape("RECTANGLE").draw();
		factory.getShape("SQUARE").draw();
	}
	
	public Shape getShape(String shape) {
		if (shape == null){
			return null;
		}        
		if (shape.equalsIgnoreCase("circle")) {
			return new Circle();
		} else if (shape.equalsIgnoreCase("rectangle")) {
			return new Rectangle();
		} else if (shape.equalsIgnoreCase("square")) {
			return new Square();
		}
		return null;
	}

}
