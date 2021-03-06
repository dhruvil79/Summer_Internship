package Main_Code;
import Logic_Of_Code.*;
import java.util.*;

public class Red_Black_Tree_Main {
	public static Scanner sc=new Scanner(System.in);
	public static void menu(){
		System.out.println("------------------------------------------------");
		System.out.println("Choose a task that you want to perform");
		System.out.println("1. Insert");
		System.out.println("2. Delete");
		System.out.println("3. Find");
		System.out.println("4. Height Of the Tree");
		System.out.println("5. Display");
		System.out.println("0. exit");
		System.out.println("------------------------------------------------");
	}
	
	public static void flow(int type)
	{
		int choice;
		int Idata;
		double Ddata;
		String Sdata;
		if(type==1)
		{
			Red_Black_Tree<Integer> rbti = new Red_Black_Tree<>();
			while(true)
			{
				menu();
				choice = sc.nextInt();
				switch(choice)
				{
					case 1:
							//Insert
							System.out.print("Enter the Integer you want to Insert : ");
							Idata = sc.nextInt();
							
							if(rbti.searchTree(Idata))
							{
								System.out.println("Element Already Exist");
							}
							
							else{
								rbti.insert(Idata);
								System.out.println("Element Inserted successfully !!");
							}
							break;

					case 2:
							//Delete
							System.out.print("Enter the Integer you want to delete : ");
							Idata = sc.nextInt();
							
							
							if(rbti.searchTree(Idata))
							{
								rbti.deleteNode(Idata); 
								System.out.println("Element Deleted!!");
							}
							
							else{
								System.out.println("Element Doesn't Exist !!!");
							}
							break;
					
					case 3:
							//find
							System.out.print("Enter the Integer you want to find : ");
							Idata = sc.nextInt();
							
							if(rbti.searchTree(Idata))
							{
								System.out.println("Element Exist in Tree");
								
							}
							else {
								System.out.println("Element Doesn't Exist !!!");
							}
							break;
					
					case 4:
							//Height
							int height=rbti.Height_Of_Tree();
							System.out.println("Height Of the Tree is :" +(height-1));
							break;
					
					case 5:
							//Display
							System.out.println("Red Black Tree Shown Below");
							rbti.printTree();
							break;
					
					case 0:
							System.exit(0);
							break;
					
					default :
							System.out.println("Enter a valid Input");
							break;		
				}
			}
		}
		else if(type==2)
		{
			Red_Black_Tree<String> rbti = new Red_Black_Tree<>();
			while(true)
			{
				menu();
				choice = sc.nextInt();
				switch(choice)
				{
					case 1:
							//Insert
							System.out.print("Enter the String you want to Insert : ");
							Sdata = sc.next();
							if(rbti.searchTree(Sdata))
							{
								System.out.println("Element Already Exist");
							}
							
							else{
								rbti.insert(Sdata);
								System.out.println("Element Inserted successfully !!");
							}
							break;

					case 2:
							//Delete
							System.out.print("Enter the String you want to delete : ");
							Sdata = sc.next();
							
							if(rbti.searchTree(Sdata))
							{
								rbti.deleteNode(Sdata); 
								System.out.println("Element Deleted!!");
								
							}
							
							else{
								System.out.println("Element Doesn't Exist !!!");
							}
							break;
					
					case 3:
							//find
							System.out.print("Enter the String you want to find : ");
							Sdata = sc.next();
							if(rbti.searchTree(Sdata))
							{
								System.out.println("Element Exist in Tree");
								
							}
							else {
								System.out.println("Element Doesn't Exist !!!");
							}
							break;
					
					case 4:
							//Height
							int height=rbti.Height_Of_Tree();
							System.out.println("Height Of the Tree is :" +(height-1));
							break;
					
					case 5:
							//Display
							System.out.println("Red Black Tree Shown Below");
							rbti.printTree();
							break;
					
					case 0:
							break;
					
					default :
							System.out.println("Enter a valid Input");
							break;		
				}
			}

		}
		else if(type==3)
		{
			Red_Black_Tree<Double> rbti = new Red_Black_Tree<>();
			while(true)
			{
				menu();
				choice = sc.nextInt();
				switch(choice)
				{
					case 1:
							//Insert
							System.out.print("Enter the Double you want to Insert : ");
							Ddata = sc.nextDouble();
							if(rbti.searchTree(Ddata))
							{
								System.out.println("Element Already Exist");
							}
							
							else{
								rbti.insert(Ddata);
								System.out.println("Element Inserted successfully !!");
							}
							break;

					case 2:
							//Delete
							System.out.print("Enter the Double you want to delete : ");
							Ddata = sc.nextDouble();
							
							if(rbti.searchTree(Ddata))
							{
								rbti.deleteNode(Ddata); 
								System.out.println("Element Deleted!!");
								
							}
							
							else{
								System.out.println("Element Doesn't Exist !!!");
							}
							break;
					
					case 3:
							//find
							System.out.print("Enter the Double nteger you want to find : ");
							Ddata = sc.nextDouble();
							if(rbti.searchTree(Ddata))
							{
								System.out.println("Element Exist in Tree");
								
							}
							else {
								System.out.println("Element Doesn't Exist !!!");
							}
							break;
					
					case 4:
							//Height
							int height=rbti.Height_Of_Tree();
							System.out.println("Height Of the Tree is :" +(height-1));
							break;
					
					case 5:
							//Display
							System.out.println("Red Black Tree Shown Below");
							rbti.printTree();
							break;
					
					case 0:
							break;
					
					default :
							System.out.println("Enter a valid Input");
							break;		
				}
			}
		}
		else
		{
			System.out.println("Invalid Choice");
			System.exit(0);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("----------------------------------------------------------------");
		System.out.println("------------------    Red Black Tree    ------------------------");
		System.out.println("----------------------------------------------------------------");
		System.out.println("Here Provide Some Data type for Red Black Tree Choose any one of them ");
		System.out.println("1.Integer");
		System.out.println("2.String");
		System.out.println("3.Double");
		System.out.print("Enter Your Choice for Data Type : ");
		int choice=sc.nextInt();
		Red_Black_Tree_Main.flow(choice);
		sc.close();
		
	}
}
