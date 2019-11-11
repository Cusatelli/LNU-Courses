package workshop2.view;

public class Console {
	
	public void start() {
		System.out.println("");
	}
	
	public void Member() {
		Console view = new Console() {
			public void Add() {
				System.out.println("Adding Member");
			};
			
			public void Remove() {
				System.out.println("Removing Member");
			};
		};
	}
	
	public void Boat() {
		Console view = new Console() {
			public void Add() {
				
			};
			
			public void Remove() {
				
			};
		};
	}
}
