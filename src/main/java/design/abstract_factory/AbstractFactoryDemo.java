package design.abstract_factory;

public class AbstractFactoryDemo {

	public static void main(String[] args) {
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		shapeFactory.getShape("CIRCLE").draw();
		shapeFactory.getShape("SQUARE").draw();
		shapeFactory.getShape("RECTANGLE").draw();
		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
		colorFactory.getColor("RED").fill();
		colorFactory.getColor("GREEN").fill();
		colorFactory.getColor("BLUE").fill();
	}
	
}
