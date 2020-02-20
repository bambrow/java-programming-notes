package design.singleton;

// same effect as DCL
// lazy initialization for static domain
// only suitable for static domain
// different from SingletonHungry, after the class is loaded, instance is not automatically initialized
// instance will be initialized when calling getInstance method
// so this method has lazy loading
// thread safe

public class SingletonInner {
	
	private static class SingletonHolder {
		private static final SingletonInner INSTANCE = new SingletonInner();
	}
	
	private SingletonInner() { }
	
	public static final SingletonInner getInstance() {
		return SingletonHolder.INSTANCE;
	}

}
