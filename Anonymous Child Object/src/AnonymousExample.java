
public class AnonymousExample {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.field.wake(); //wake up at 6, go to work
		
		anony.method1(); //wake up at 7, walk
		
		anony.method2(
				new Person() {
					void study() {
						System.out.println("study");
					}
					@Override
					void wake() {
						System.out.println("wake up at 8");
						study();
					}
				}
				);//wake up at 8, study
	}
}
