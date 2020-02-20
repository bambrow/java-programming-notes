package design.singleton;

// double-checked locking
// lazy loading
// thread safe
// high efficiency

public class SingletonDCL {

	private volatile static SingletonDCL instance;
	private SingletonDCL() { }
	
	public static SingletonDCL getInstance() {
		if (instance == null) {
			synchronized (SingletonDCL.class) {
				if (instance == null) {
					instance = new SingletonDCL();
				}
			}
		}
		return instance;
	}
	
}
