package personandproblem;

public class Problem {
    private final String      name;
    private ProblemType   type;
    private ProblemStatus status;

    public Problem(String name, ProblemType type) {
        this.name = name;
        this.type = type;
        this.status = ProblemStatus.UNSOLVED;
    }

    public String getName() {
        return this.name;
    }

    public ProblemType getType() {
        return this.type;
    }

    public void setType(ProblemType newType) {
        this.type = newType;
    }

    public void updateType(ProblemType newType) {
        setType(newType);
    }

    public boolean isSolved() {
        return this.status == ProblemStatus.SOLVED;
    }

    public void solve() {
        this.status = ProblemStatus.SOLVED;
    }
}
