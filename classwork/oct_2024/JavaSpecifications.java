public class JavaSpecifications{
	public static void main(String[] args){
		System.out.printf("Java version: %s%n", System.getProperty("java.version"));
		System.out.printf("java Runtime Version: %s%n", System.getProperty("java.runtime.version"));
		System.out.printf("java Home: %s%n", System.getProperty("java.home"));
		System.out.printf("Java Vendor: %s%n", System.getProperty("java.vendor"));
		System.out.printf("Java Vendor URL: %s%n", System.getProperty("java.vendor.url"));
		System.out.printf("Java Class Path: %s%n", System.getProperty("java.class.path"));
	}
}
