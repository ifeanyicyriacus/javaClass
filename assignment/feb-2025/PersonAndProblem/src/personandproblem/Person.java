package personandproblem;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Person {
    private final String             username;
    private final String             fullName;
    private final ArrayList<Problem> problems;

    public Person(String username, String fullName) {
        this.username = username;
        this.fullName = fullName;
        this.problems = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public ArrayList<Problem> getProblems() {
        return problems;
    }

    public void add(String name, ProblemType type) {
        Problem problem = new Problem(name, type);
        problems.add(problem);
    }

    public ArrayList<Problem> getUnsolvedProblems() {
        return problems
                .stream()
                .filter(problem -> !problem.isSolved())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void solveProblem(String name) {
        Problem problem = findProblemByName(name);
        problem.solve();
    }

    private Problem findProblemByName(String name) {
        for (Problem problem : problems) {
            if (problem.getName().equals(name)) {
                return problem;
            }
        } throw new IllegalArgumentException("Problem not found");
    }
}
