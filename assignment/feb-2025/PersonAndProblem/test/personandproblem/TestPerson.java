package personandproblem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPerson {

    Person person;
    private final String username = "username";
    private final String fullName = "Full Name";
    String[]      names = {"Achieving Excellence", "Business Idea", "Paying Tuition"};
    ProblemType[] types = {ProblemType.TECHNICAL, ProblemType.BUSINESS, ProblemType.EDUCATION};


    @BeforeEach
    public void setUp() {
        person = new Person(username, fullName);
    }

    @Test
    public void testPerson_isWasCreatedSuccessfully() {
        assertNotNull(person);
        assertEquals(username, person.getUsername());
        assertEquals(fullName, person.getFullName());
        assertNotNull(person.getProblems());
    }

    @Test
    public void testPerson_canAddToProblemsSuccessfully() {
        assertEquals(0, person.getProblems().size());
        person.add(names[0], types[0]);
        assertEquals(1, person.getProblems().size());
        assertEquals(1, person.getUnsolvedProblems().size());
        assertEquals(names[0], person.getProblems().getFirst().getName());
        assertEquals(types[0], person.getProblems().getFirst().getType());
        assertEquals(1, person.getUnsolvedProblems().size());
    }

    @Test
    public void testPerson_canSolveProblemSuccessfully() {
        person.add(names[0], types[0]);
        person.add(names[1], types[1]);
        person.add(names[2], types[2]);
        assertEquals(3, person.getProblems().size());
        assertEquals(3, person.getUnsolvedProblems().size());
        person.solveProblem(names[1]);
        assertEquals(3, person.getProblems().size());
        assertEquals(2, person.getUnsolvedProblems().size());
        person.getUnsolvedProblems()
                .forEach(problem -> assertNotEquals(problem.getName(), names[1]));
    }

    @Test
    public void testPerson_tryingToSolveProblemThatDoesNotExistThrowsException() {
        person.add(names[0], types[0]);
        assertThrows(IllegalArgumentException.class,
                ()-> person.solveProblem(names[1]));
    }
}
