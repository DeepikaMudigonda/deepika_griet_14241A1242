import java.util.Date;
import java.util.*;
import java.lang.*;
/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
class mycom implements Comparator{
public int compare(Object o1,Object o2){  
Student s1=(Student)o1;  
Student s2=(Student)o2;  
 Date sb1=s1.getBirthDate();
 Date sb2=s2.getBirthDate();
 return sb1.compareTo(sb2);
}    
}
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	ArrayList<Student> ts=new ArrayList<Student>();
	TreeSet<Student> tree=new TreeSet<Student>(new mycom());

	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {

		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		for(int i=0;i<students.length;i++)
			ts.add(students[i]);
		// Add your implementation here
	}

	@Override
	public Student getStudent(int index) {
		Student s=ts.get(index);
		// Add your implementation here
		return s;
	}

	@Override
	public void setStudent(Student student, int index) {
		ts.set(index,student);
		// Add your implementation here
	}

	@Override
	public void addFirst(Student student) {
		ts.add(0,student);
		// Add your implementation here
	}

	@Override
	public void addLast(Student student) {
		ts.add(ts.size(),student);
		// Add your implementation here
	}

	@Override
	public void add(Student student, int index) {
		ts.add(index,student);
		// Add your implementation here
	}

	@Override
	public void remove(int index) {
		ts.remove(index);
		// Add your implementation here
	}

	@Override
	public void remove(Student student) {
			ts.remove(student);
		// Add your implementation here
	}

	@Override
	public void removeFromIndex(int index) {
		index++;
		for(int i=index;i<ts.size();i++){
			ts.remove(i);
		}
		// Add your implementation here
	}

	@Override
	public void removeFromElement(Student student) {
		ListIterator itr=ts.listIterator();
		int count=0;
		while(itr.hasNext()){
			Student s=(Student)itr.next();
			count++;
			if(s==student){
				for(int i=count;i<ts.size();i++)
				{
					ts.remove(i);
				}
				break;
			}
		}
		// Add your implementation here
	}

	@Override
	public void removeToIndex(int index) {
		for(int i=0;i<index;i++){
			ts.remove(i);
		}
		// Add your implementation here
	}

	@Override
	public void removeToElement(Student student) {
			ListIterator itr=ts.listIterator();
		
		while(itr.hasNext()){
				
			Student s=(Student)itr.next();
			ts.remove(s);
				
			if(s==student){
				ts.add(s);
				break;
			}
		}
		// Add your implementation here
	}

	@Override
	public void bubbleSort() {
	Collections.sort(ts);
	}
	@Override
	public Student[] getByBirthDate(Date date) {
		tree.addAll(ts);
		Iterator itr= tree.iterator();
		Student s=null;
		while(itr.hasNext()){
			 s=(Student)itr.next();
			if(s.getBirthDate()==date){
				break;
			}
		}
		TreeSet<Student> st=(TreeSet)tree.headSet(s);
		ArrayList<Student> a=new ArrayList<Student>(st);
		Student[] z= (Student[])a.toArray(new Student[0]);
		return z;
		
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your 
		Student s1,s2,s;
		s1=null;
		s2=null;
		int count=0;
		Iterator itr= tree.iterator();

		while(itr.hasNext()){
			 s=(Student)itr.next();
			
			if(s.getBirthDate()==lastDate){
				
				if(count==0){
				count++;	
				s1=s;
				}
				if(count==1){
					s2=s;
				}
			}

		}
		TreeSet<Student> st=(TreeSet)tree.subSet(s1,s2);
		ArrayList<Student> a=new ArrayList<Student>(st);
		Student[] z= (Student[])a.toArray(new Student[0]);
		return z;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
