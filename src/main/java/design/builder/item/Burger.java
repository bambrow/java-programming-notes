package design.builder.item;

import design.builder.packing.Packing;
import design.builder.packing.Wrapper;

public abstract class Burger implements Item {

	@Override
	public Packing packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();

}
