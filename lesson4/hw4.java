/*
Выполнил: Ломакин Антон
Дата: 05.09.2016
Все фамилии, адреса, зарплаты являются вымышленными. Все совпадения случайны.
*/
class hw4{
	public static void main(String[] args){
		Employee[] arr = new Employee[5];
		
		arr[0]= new Employee("Anton Lomakin", 30, "lomakin.antonio@gmail.com", "548795467", 500000);
		arr[1]= new Employee("Ivan Ivanoff", 40, "test@gmail.com", "890342808975867", 40000);
		arr[2]= new Employee("Peter Petroff", 50, "utro@gmail.com", "8907565679789", 30000);
		arr[3]= new Employee("Sergey Sergeev", 60, "kofe@gmail.com", "890808975867", 200000);
		arr[4]= new Employee("Ivan Makedonsky", 70, "chay", "8351898798978", 150000);
		
		for(Employee emp: arr){
			if(emp.getAge()>40) emp.printInfo();
		}
	}
}

class Employee{
	private String name;
	private int age;
	private String email;
	private String tel;
	private int salary;
	
	Employee(String name, int age, String email, String tel, int salary){
		this.name = name;
		this.age = age;
		this.email = email;
		this.tel = tel;
		this.salary = salary;
	}
	void printInfo(){
		System.out.println("Name:"+name+"; age:"+age+"; email:"+email+"; tel:"+tel+"; salary:"+salary);
	}
	
	int getAge(){
		return age;
	}
	}
		