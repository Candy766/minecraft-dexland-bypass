import java.util.Timer;
import java.util.TimerTask;

public class CommandScheduler {
    private final Timer timer;

    public CommandScheduler() {
        this.timer = new Timer();
    }

    // Schedule a task to run after a delay
    public void scheduleTask(Runnable task, long delay) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                task.run();
            }
        }, delay);
    }

    // Schedule a task to run at a fixed rate
    public void scheduleAtFixedRate(Runnable task, long delay, long period) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                task.run();
            }
        }, delay, period);
    }

    // Cancel all scheduled tasks
    public void cancelTasks() {
        timer.cancel();
    }
}