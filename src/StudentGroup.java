import java.util.Date;

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
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
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
		// Add your implementation here
		if(students == null)
			throw new IllegalArgumentException("null!");
		else{
		for(int i = 0;i < students.length;i ++)
		{
			this.students[i].setId(students[i].getId());
			this.students[i].setFullName(students[i].getFullName());
			this.students[i].setBirthDate(students[i].getBirthDate());
			this.students[i].setAvgMark(students[i].getAvgMark());
		}
		}
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length)
			throw new IllegalArgumentException("null!");
		else
			for(int i = 0;i < students.length;i ++)
				if(i == index)
					return students[i];
		return null;
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException("null!");
		else if(index < 0 || index >= students.length)
			throw new IllegalArgumentException("null!");
		else{
		for(int i = 0;i < students.length;i ++)
			if(i == index){
				students[i].setId(student.getId());
				students[i].setFullName(student.getFullName());
				students[i].setBirthDate(student.getBirthDate());
				students[i].setAvgMark(student.getAvgMark());
			}
		}
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(students == null)
			throw new IllegalArgumentException("null!");
		else{
		Student[] s = new Student[(this.students.length) + 1];
		s[0].setId(student.getId());
		s[0].setFullName(student.getFullName());
		s[0].setBirthDate(student.getBirthDate());
		s[0].setAvgMark(student.getAvgMark());
		for(int i = 0;i < students.length;i ++)
		{
			s[i + 1].setId(students[i].getId());
			s[i + 1].setFullName(students[i].getFullName());
			s[i + 1].setBirthDate(students[i].getBirthDate());
			s[i + 1].setAvgMark(students[i].getAvgMark());
		}
		students = s;
		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(students == null)
			throw new IllegalArgumentException("null!");
		else{
		Student[] s = new Student[(this.students.length) + 1];
		for(int i = 0;i < students.length;i ++)
		{
			s[i].setId(students[i].getId());
			s[i].setFullName(students[i].getFullName());
			s[i].setBirthDate(students[i].getBirthDate());
			s[i].setAvgMark(students[i].getAvgMark());
		}
		s[s.length - 1].setId(student.getId());
		s[s.length - 1].setFullName(student.getFullName());
		s[s.length - 1].setBirthDate(student.getBirthDate());
		s[s.length - 1].setAvgMark(student.getAvgMark());
		students = s;
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException("null!");
		else if(index < 0 || index >= students.length)
			throw new IllegalArgumentException("null!");
		else{
		Student[] s = new Student[(this.students.length) + 1];
		for(int i = 0;i < students.length;i ++){
			if(i == index){
				s[i].setId(student.getId());
				s[i].setFullName(student.getFullName());
				s[i].setBirthDate(student.getBirthDate());
				s[i].setAvgMark(student.getAvgMark());
			}
			else if(i < index){
				s[i].setId(students[i].getId());
				s[i].setFullName(students[i].getFullName());
				s[i].setBirthDate(students[i].getBirthDate());
				s[i].setAvgMark(students[i].getAvgMark());
			}
			else if(i > index){
				s[i + 1].setId(students[i].getId());
				s[i + 1].setFullName(students[i].getFullName());
				s[i + 1].setBirthDate(students[i].getBirthDate());
				s[i + 1].setAvgMark(students[i].getAvgMark());
			}
		}
		students = s;
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length)
			throw new IllegalArgumentException("null!");
		else{
		Student[] s = new Student[(this.students.length) - 1];
		for(int i = 0;i < students.length;i ++){
			if(i == index){
			}
			else if(i < index){
				s[i].setId(students[i].getId());
				s[i].setFullName(students[i].getFullName());
				s[i].setBirthDate(students[i].getBirthDate());
				s[i].setAvgMark(students[i].getAvgMark());
			}
			else if(i > index){
				s[i - 1].setId(students[i].getId());
				s[i - 1].setFullName(students[i].getFullName());
				s[i - 1].setBirthDate(students[i].getBirthDate());
				s[i - 1].setAvgMark(students[i].getAvgMark());
			}
		}
		students = s;
		}
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException("null!");
		else{
		int flag = 0;
		Student[] s = new Student[(this.students.length) - 1];
		for(int i = 0;i < students.length;i ++){
			if(students[i].getId() == student.getId()){
				flag = 1;
			}
			else if((students[i].getId() != student.getId()) && flag == 0){
				s[i].setId(students[i].getId());
				s[i].setFullName(students[i].getFullName());
				s[i].setBirthDate(students[i].getBirthDate());
				s[i].setAvgMark(students[i].getAvgMark());
			}
			else if((students[i].getId() != student.getId()) && flag == 1){
				s[i - 1].setId(students[i].getId());
				s[i - 1].setFullName(students[i].getFullName());
				s[i - 1].setBirthDate(students[i].getBirthDate());
				s[i - 1].setAvgMark(students[i].getAvgMark());
			}
		}
		students = s;
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length)
			throw new IllegalArgumentException("null!");
		else{
		Student[] s = new Student[(this.students.length) - 1];
		for(int i = 0;i < students.length;i ++){
			if(i == index){
			}
			else if(i < index){
				s[i].setId(students[i].getId());
				s[i].setFullName(students[i].getFullName());
				s[i].setBirthDate(students[i].getBirthDate());
				s[i].setAvgMark(students[i].getAvgMark());
			}
			else if(i > index){
			}
		}
		students = s;
		}
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException("null!");
		else{
		int flag = 0;
		Student[] s = new Student[(this.students.length) - 1];
		for(int i = 0;i < students.length;i ++){
			if(students[i].getId() == student.getId()){
				flag = 1;
			}
			else if((students[i].getId() != student.getId()) && flag == 0){
				s[i].setId(students[i].getId());
				s[i].setFullName(students[i].getFullName());
				s[i].setBirthDate(students[i].getBirthDate());
				s[i].setAvgMark(students[i].getAvgMark());
			}
			else if((students[i].getId() != student.getId()) && flag == 1){
				
			}
		}
		students = s;
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length)
			throw new IllegalArgumentException("null!");
		else{
		Student[] s = new Student[(this.students.length) - 1];
		for(int i = 0;i < students.length;i ++){
			if(i == index){
			}
			else if(i < index){
				
			}
			else if(i > index){
				s[i].setId(students[i].getId());
				s[i].setFullName(students[i].getFullName());
				s[i].setBirthDate(students[i].getBirthDate());
				s[i].setAvgMark(students[i].getAvgMark());
			}
		}
		students = s;
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException("null!");
		else{
		int flag = 0;
		Student[] s = new Student[(this.students.length) - 1];
		for(int i = 0;i < students.length;i ++){
			if(students[i].getId() == student.getId()){
				flag = 1;
			}
			else if((students[i].getId() != student.getId()) && flag == 0){
				s[i].setId(students[i].getId());
				s[i].setFullName(students[i].getFullName());
				s[i].setBirthDate(students[i].getBirthDate());
				s[i].setAvgMark(students[i].getAvgMark());
			}
			else if((students[i].getId() != student.getId()) && flag == 1){
				
			}
		}
		students = s;
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		int c,w;
		Student temp;
		for(c = 0;c < this.students.length;c ++)
			for(w = 0;w < this.students.length;w ++)
				if(students[w].getId() < students[w - 1].getId())
				{
					temp = students[w - 1];
					students[w - 1] = students[w];
					students[w] = temp;
				}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date == null)
			throw new IllegalArgumentException("null!");
		else{
		Student[] s = new Student[this.students.length];
		for(int i = 0;i < students.length;i ++){
			if(students[i].getBirthDate().equals(date)){
				s[i].setId(students[i].getId());
				s[i].setFullName(students[i].getFullName());
				s[i].setBirthDate(students[i].getBirthDate());
				s[i].setAvgMark(students[i].getAvgMark());
			}
		}
		return s;
		}
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate == null || lastDate == null)
			throw new IllegalArgumentException("null!");
		else{
		Student[] s = new Student[this.students.length];
		for(int i = 0;i < students.length;i ++){
			if(students[i].getBirthDate().after(firstDate) && students[i].getBirthDate().before(lastDate)) {
				s[i].setId(students[i].getId());
				s[i].setFullName(students[i].getFullName());
				s[i].setBirthDate(students[i].getBirthDate());
				s[i].setAvgMark(students[i].getAvgMark());
			}
		}
		return s;
		}
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
		Student[] s = new Student[this.students.length];
		double max = students[0].getAvgMark();
		for(int i = 0;i < students.length;i ++){
			if(max < students[i].getAvgMark())
            {
                max = students[i].getAvgMark();
                s[i] = students[i];
            }
		}
		return s;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException("null!");
		else
			for(int i = 0;i < students.length;i ++)
				if(students[i].getId() == student.getId() && i != (students.length - 1))
					return students[i + 1];
		return null;
	}
}
