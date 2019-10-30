
public class Anonymous {
	RemoteControl field = new RemoteControl() {
		@Override
		public void turnOn() {
			System.out.println("turn on TV");
		}
		@Override
		public void turnOff() {
			System.out.println("turn off TV");
		}
	};
	
	void method1() {
		RemoteControl localVar = new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("turn on Audio");
			}
			@Override
			public void turnOff() {
				System.out.println("turn off Audio");
			}
		};
		localVar.turnOn();
	}
	
	void method2(RemoteControl rc) {
		rc.turnOn();
	}
}
