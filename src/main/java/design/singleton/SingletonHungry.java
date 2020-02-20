package design.singleton;

// no lazy loading
// use classloader
// thread safe
// possible garbage object, wasting memory

public class SingletonHungry {
	
	private static SingletonHungry instance = new SingletonHungry();
	private SingletonHungry() { }
	
	public static SingletonHungry getInstance() {
		return instance;
	}

}
