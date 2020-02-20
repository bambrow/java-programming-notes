package design.builder.item;

public class VegBurger extends Burger {

	@Override
	public String name() {
		return "Veggie Burger";
	}

	@Override
	public float price() {
		return 2.75f;
	}

}
