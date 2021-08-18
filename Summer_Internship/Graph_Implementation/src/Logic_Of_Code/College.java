package Logic_Of_Code;
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;


public class College{
	public static void main(String[] args) throws Exception{
	  College daiict = new College();
	  daiict.fillData("./data.txt");
	}
	
	public LinkedList<Student> fillData(String fileName) throws Exception{
		FileReader fr=new FileReader(fileName);    
        BufferedReader br=new BufferedReader(fr);  
        
        LinkedList<Student> studentList = new LinkedList<Student>();
  	  
  	 	String line = br.readLine();
  	 	while(!line.equals("-1")){
  	  		String[] str = line.trim().split("\\t+");
  	  		
  	  		int index = Integer.parseInt(str[0]);
  	  		long id = Long.parseLong(str[1]);
  	  		String name = str[3];
  	  		Double cpi = Double.parseDouble(str[2]);
  	  		
  	  		studentList.add(new Student(index,id,name,cpi));
  	  		
  	  		line = br.readLine();
  	 	}
  	 	br.close();    
        fr.close(); 
        return studentList;
	}	
	public void printStudentData(LinkedList<Student> studentList){
		Iterator<Student> itr=studentList.iterator();  
		  while(itr.hasNext())
		  {
			  Student student = itr.next();	  
			  System.out.println(student.getIndex()+" "+student.getId() +" "+student.getCpi()+" "+student.getName());  
		  }
	}
	public Red_Black_Tree_2<Integer> getTreeBasedOnIndex(LinkedList<Student> studentList){
		Red_Black_Tree_2<Integer> indexTree = new Red_Black_Tree_2<Integer>();
		for(Student s : studentList){
		    Integer index = s.getIndex();
		    indexTree.insert(new Pair<Integer>(s,index));
		}
		return indexTree;
	}
	
	public Red_Black_Tree_2<Long> getTreeBasedOnStudentId(LinkedList<Student> studentList){
		Red_Black_Tree_2<Long> idTree = new Red_Black_Tree_2<Long>();
		for(Student s : studentList){
			  Long id = s.getId();
			  idTree.insert(new Pair<Long>(s,id));
		  }
		return idTree;
	}
	
	public Red_Black_Tree_2<String> getTreeBasedOnName(LinkedList<Student> studentList){
		Red_Black_Tree_2<String> nameTree = new Red_Black_Tree_2<String>();
		for(Student s : studentList){
			  String name = s.getName();
			  nameTree.insert(new Pair<String>(s,name));
		  }
		return nameTree;
	}
}