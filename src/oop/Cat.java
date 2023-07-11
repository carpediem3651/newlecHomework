package oop;

public class Cat {
	private String name;
	private int age;
	
	public Cat() {
	
	}
	
	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}


	public void sayAge() {
		System.out.println("제 나이는 " +age+ "입니다.");
	}
	
	public void lie() {
		System.out.println("생쥐가 나타났다.");
	}
}
