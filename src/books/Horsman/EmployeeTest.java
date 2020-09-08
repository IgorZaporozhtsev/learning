package books.Horsman;



public class EmployeeTest {



    public static void main(String[] args) {

        //заполнение массива staff тремя обьектами

        Employee[] staff = new Employee[3];

        staff[0]  = new Employee("Сергей Моршинский", 75000, 1987, 12, 15);
        staff[1]  = new Employee("Андрей Головач", 5000, 1989, 10, 1);
        staff[2]  = new Employee("Дмитрий Чевинский", 40000, 1990, 3, 15);

        //увелечение зарплаты на 5%

        for (Employee e: staff) {

            e.raiseSalary(5);
        }


        //вывод информации о всех объектах Employee

        for (Employee e: staff) {
            System.out.println("имя = " + e.getName() + ",зарплата = " + e.getSalary() + ",hireDay = " + e.getHireDay());

        }

    }


/*

    public class Employee {

        public Employee (String n, double s, int year, int month, int day){

        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);

            //класс   GregorianCalendar январю соответствует 0

            hireDay = calendar.getTime();

        }

        public String getName (){
            return name;
        }

        public double getSalary(){
            return salary;
        }

        public Date getHireDay(){
            return hireDay;
        }

        public void raiseSalary (double byPercent){

            double raise = salary * byPercent / 100;
            salary += raise;


        }
    }

*/




}