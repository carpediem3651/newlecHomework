package oop;

public class LiarCat extends Cat {
	private String name;
	private int age;
	
	public LiarCat(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public void sayAge() {
		super.sayAge();
	}

	@Override
	public void lie() {
		// TODO Auto-generated method stub
		super.lie();
	}
	
	
	
//	public void sayAge() {
//		System.out.println("제 나이는"+age+"입니다");
//	}
	
}
