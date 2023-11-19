import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerClass {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int counter = 10;
            @Override
            public void run() {
                if (counter > 0) {
                    System.out.println(counter + " seconds");
                    counter--;
                }
                else  {
                    System.out.println("Happy new Year!");
                    timer.cancel(); 
                }
            }
        };
        //timer.schedule(task, 0);    
        
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, 2023);
        date.set(Calendar.MONTH, 12);
        date.set(Calendar.DAY_OF_MONTH, 31);
        date.set(Calendar.HOUR_OF_DAY, 11);
        date.set(Calendar.MINUTE,59 );
        date.set(Calendar.SECOND, 50);
        date.set(Calendar.MILLISECOND, 0);

        timer.schedule(task, date.getTime());
        
        //timer.scheduleAtFixedRate(task, 0, 1000);
        timer.scheduleAtFixedRate(task, date.getTime(), 1000);
    }
}
