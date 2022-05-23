package event;

public enum MethodExecutionStatus {
    BEGIN("1"),END("2");
    private String name;
    private MethodExecutionStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
