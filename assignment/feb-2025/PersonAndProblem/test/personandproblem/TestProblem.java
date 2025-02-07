package personandproblem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestProblem {
    Problem     problem;
    String      name = "Start Up cost";
    ProblemType type = ProblemType.BUSINESS;

    @BeforeEach
    public void setUp() {
        problem = new Problem(name, type);
    }

    @Test
    void testProblem_Exist() {
        assertNotNull(problem);
    }

    @Test
    void testProblem_hasNameTypeAndStatus() {
        assertEquals(name, problem.getName());
        assertEquals(type, problem.getType());
        assertFalse(problem.isSolved());
    }

    @Test
    void testProblem_typeCanBeChanged() {
        assertEquals(type, problem.getType());
        ProblemType newType = ProblemType.EDUCATION;
        problem.updateType(newType);
        assertEquals(newType, problem.getType());
    }

    @Test
    void testProblem_scanBeSolved() {
        assertFalse(problem.isSolved());
        problem.solve();
        assertTrue(problem.isSolved());
    }




}
