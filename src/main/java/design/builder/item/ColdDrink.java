package design.builder.item;

import design.builder.packing.Bottle;
import design.builder.packing.Packing;

public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();

}
