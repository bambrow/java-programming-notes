package design.abstract_factory;

import design.abstract_factory.color.Color;
import design.abstract_factory.shape.Shape;

public abstract class AbstractFactory {
	public abstract Color getColor(String color);
	public abstract Shape getShape(String shape);
}
