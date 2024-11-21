import java.util.Date;

class ExamChecking extends Thread {
    private static int examSheets = 500;
    private final int maxChecks;

    public ExamChecking(int maxChecks) {
        this.maxChecks = maxChecks;
    }

    @Override
    public void run() {
        int checks = 0;

        while (checks < maxChecks) {
            synchronized (ExamChecking.class) {
                if (examSheets <= 0) {
                    System.out.println("There is no any exam sheet left! All papers were already checked!!!");
                    System.exit(0);
                }

                examSheets -= 50;
                checks++;
                System.out.printf(
                        "%s finished checking, at: %s, exam sheet count is now %d%n",
                        getName(),
                        new Date(),
                        examSheets
                );
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("%s has completed their work.%n", getName());
    }


}
