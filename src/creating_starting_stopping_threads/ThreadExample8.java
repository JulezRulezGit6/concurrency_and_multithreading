package creating_starting_stopping_threads;

public class ThreadExample8 {
    public static class StoppableRunnable implements Runnable {

        private boolean stopRequested = false;

        public static void main(String[] args) {
            StoppableRunnable stoppableRunnable = new StoppableRunnable();
            Thread thread = new Thread(stoppableRunnable,"Thread");
            thread.start();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Requesting Stop");
            stoppableRunnable.requestStop();
            System.out.println("Stop Requested");

        }

        @Override
        public void run() {
            System.out.println("StoppableRunnable Running");
            while (!isStopRequested()) {
                sleep(1000);
                System.out.println("....");
            }
            System.out.println("StoppableRunnable Stopped");

        }

        public void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void requestStop() {
            this.stopRequested = true;
        }

        public boolean isStopRequested() {
            return this.stopRequested;
        }
    }
}
