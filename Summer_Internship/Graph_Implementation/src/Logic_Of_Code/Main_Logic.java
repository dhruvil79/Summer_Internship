package Logic_Of_Code;
import java.util.*;

class Pair<T extends Comparable<T>>{
	Student ref;
	T data;
	Pair(Student s,T data){
		this.ref = s;
		this.data = data;
	}
}

public class Main_Logic{
	public static void main(String[] args) throws Exception{
	  College daiict = new College();
	  LinkedList<Student> studentList =  daiict.fillData("F:\\DA\\SI\\Git Code\\Summer_Internship\\Graph_Implementation\\src\\Logic_Of_Code\\data.txt");
	  //daiict.printStudentData(studentList); 

	  
	  Red_Black_Tree_2<Integer> indexTree = daiict.getTreeBasedOnIndex(studentList);
	  Red_Black_Tree_2<Long> idTree = daiict.getTreeBasedOnStudentId(studentList);
	  Red_Black_Tree_2<String> nameTree = daiict.getTreeBasedOnName(studentList);

	  Main_Logic obj = new Main_Logic();
	  obj.welcomeMessage("Dhirubhai Ambani Institute of Information and Communication Technology(DAIICT)");	  
	  obj.driver(indexTree,idTree,nameTree); 
	}
	
	public void welcomeMessage(String collegeName){
		System.out.println("Welcome to "+collegeName);
		System.out.println("\nHere we are having list of our students .We have there Index,Student ID,name and their CPI");
	}
	public void driver(Red_Black_Tree_2<Integer> indexTree,Red_Black_Tree_2<Long> idTree,Red_Black_Tree_2<String> nameTree){
		System.out.println("By which criteria do you want to search : ");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("1. By Index");
		System.out.println("2. By Student id");
		System.out.println("3. By Name");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.print("Enter Your Choice : ");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		System.out.println("-------------------------");
		switch(choice){
		case 1 :
			System.out.print("Enter Index to search : ");
			int index = input.nextInt();
			if(indexTree.searchTree(index).data!=null){
				//System.out.println("Found");
				Student s = indexTree.searchTree(index).ref;
				System.out.println("--------------------");
				System.out.println("Name : "+s.getName());
				System.out.println("ID   : "+s.getId());
				System.out.println("CPI  : "+s.getCpi());
				System.out.println("---------------------");
			}
			else{
			    System.out.println("not found");
			}
			break;
		case 2:
			System.out.print("Enter Student id to search : ");
			long id = input.nextLong();
			if(idTree.searchTree(id).data!=null){
				//System.out.println("found");
				Student s = idTree.searchTree(id).ref;
				System.out.println("--------------");
				System.out.println("Name : "+s.getName());
				System.out.println("ID   : "+s.getId());
				System.out.println("CPI  : "+s.getCpi());
				System.out.println("--------------");
			}
			else{
			    System.out.println("not found");
			}
			break;
		case 3:
			System.out.print("Enter name to search : ");
			
			input.nextLine();
			String name = input.nextLine();
			
			if(nameTree.searchTree(name).data!=null){
				//System.out.println("found");
				Student s = nameTree.searchTree(name).ref;
				System.out.println("--------------");
				System.out.println("Name : "+s.getName());
				System.out.println("ID   : "+s.getId());
				System.out.println("CPI  : "+s.getCpi());
				System.out.println("--------------");
			}
			else{
			    System.out.println("not found");
			    System.out.println("asdfadf "+name);
			}
			break;
		default:
			System.out.println("Please enter a valid input!");
			break;
		}
		input.close();
	}
}
