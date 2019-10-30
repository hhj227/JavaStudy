
public class Anonymous {
	Person field = new Person() {
		void work() {
			System.out.println("go to work");
		}
		@Override
		void wake() {
			System.out.println("wake up at 6");
			work();
		}
	};
	
	void method1() {
		Person localVar = new Person() {
			void walk() {
				System.out.println("walk");
			}
			@Override
			void wake() {
				System.out.println("wake up at 7");
				walk();
			}
		};
		localVar.wake();
	}
	
	void method2(Person person) {
		person.wake();
	}
}
