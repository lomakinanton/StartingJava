class hw5{
	public static void main(String[] args){
		Animal[] arr = new Animal[3];
		arr[0] = new Dog("Gray", 50);
		arr[1] = new Fox("Lisa", 100);
		arr[2] = new Cat("Murka", 150, false);
		for (Animal a : arr){
			a.jump();
			a.swim();
			a.run();
			System.out.println("");
		}
	}
}

//Всякие мутанты нам не нужны, поэтому абстракт
abstract class Animal{
	private String name;
	private int jumpHeight;
	private boolean canSwim=true;
	
	// бегать может каждое животное, поэтому файнал
	final void run(){
		System.out.println("Animal " + name + " is runnig!");
	}
	//Общий для всех животных конструктор, который необходимо переопределить в каждом дочернем классе
	Animal(String name, int jumpHeight){
		this.name = name;
		this.jumpHeight = jumpHeight;
	}
	Animal(String name, int jumpHeight, boolean canSwim){
		this.name = name;
		this.jumpHeight = jumpHeight;
		this.canSwim = canSwim;
	}
	abstract void jump(); 	//каждое животное может прыгать, но все делают это по разному
	void swim(){
		if (canSwim) System.out.println("Animal named " +name+ " is swimmig!");
		else System.out.println("Animal named " +name+ " can not swimmig!");
	}
	String getName(){
		return name;
	}
	int getjumpHeight(){
		return jumpHeight;
	}
	boolean getcanSwim(){
		return canSwim;
	}
}

class Dog extends Animal{
	//Переопределяемый конструктор для собаки
	Dog(String name, int jumpHeight){
		super(name, jumpHeight);
	}
	@Override
	void jump(){
		System.out.println("Dog named " +getName() +", jumped by "+getjumpHeight()+" meters!");
		}
}

class Cat extends Animal{
	//Переопределяемый конструктор для кота
	Cat(String name, int jumpHeight, boolean canSwim){
		super(name, jumpHeight, canSwim);
	}
	@Override
	void jump(){
		System.out.println("Cat named " +getName() +", jumped by "+getjumpHeight()+" meters!");
	}
}

class Fox extends Animal{
	//Переопределяемый конструктор для лисы
	Fox(String name, int jumpHeight){
		super(name, jumpHeight);
	}
	@Override
	void jump(){
		System.out.println("Fox named " +getName() +", jumped by "+getjumpHeight()+" meters!");
	}
}
