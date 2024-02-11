package telran.java51.student.dao;

import java.util.Set;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import telran.java51.student.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	Stream<Student> getAllBy();

	Stream<Student> findByNameIgnoreCase(String name);

	long countByNameInIgnoreCase(Set<String> names);

	
	/**
	 * 
	 *  'scores.$exam' / refers to the field in the scores map with the key equal to the exam parameter.
     *  '$exists': true / checks if the field exists in the document.
     *  '$gt': ?1    / checks if the value of the field is greater than the value provided in the score parameter.
	 * 
	 * @param exam
	 * @param score
	 * @return Stream
	 */
	
	
	@Query("{'scores.?0':{'$gt': ?1}}")
	Stream<Student> findByExamAndScoreGreaterThan(String exam, int score);
	
	
}
