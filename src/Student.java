public class Student {
    private String name;
    private double currentScholarship;
    private double newScholarship;

    public Student(String name, double currentScholarship, double newScholarship) {
        this.name = name;
        this.currentScholarship = currentScholarship;
        this.newScholarship = newScholarship;
    }

    public String getName() {
        return name;
    }

    public double getCurrentScholarship() {
        return currentScholarship;
    }

    public double getNewScholarship() {
        return newScholarship;
    }

    // Method to calculate scholarship increase
    public double getScholarshipIncrease() {
        return newScholarship - currentScholarship;
    }

    // Method to display scholarship details
    public void showScholarship() {
        System.out.printf("Student: %s, Current Scholarship: %.2f, New Scholarship: %.2f, Increase: %.2f%n",
                name, currentScholarship, newScholarship, getScholarshipIncrease());
    }
}
