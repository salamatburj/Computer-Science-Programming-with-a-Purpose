/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */


public class Clock {
    private int hour, minute;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if ((h < 24) && (h >= 0)) hour = h;
        else throw new IllegalArgumentException("Hours should be between 0 and 23");
        if ((m < 60) && (m >= 0)) minute = m;
        else throw new IllegalArgumentException("Minutes should be between 0 and 59");
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        // HH:MM

        if (s.length() != 5) {
            throw new IllegalArgumentException("Format should be HH:MM");
        }
        if (!s.substring(2, 3).equals(":")) {
            StdOut.print(s.substring(2, 3));
            throw new IllegalArgumentException("Format should be HH:MM");
        }


        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        if ((h < 24) && (h >= 0)) hour = h;
        else throw new IllegalArgumentException("Hours should be between 0 and 23");
        if ((m < 60) && (m >= 0)) minute = m;
        else throw new IllegalArgumentException("Minutes should be between 0 and 59");
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String h = Integer.toString(hour);
        String m = Integer.toString(minute);
        if (hour < 10) h = "0" + h;
        if (minute < 10) m = "0" + m;
        return h + ":" + m;

    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hour < that.hour) return true;
        else if (hour == that.hour) {
            if (minute < that.minute) return true;
        }
        return false;
    }


    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (minute + 1 <= 59) minute++;
        else {
            if (hour < 23) {
                hour++;
            }
            else {
                hour = 0;
            }
            minute = 0;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException("delta can not be negative");
        int hdelta = delta / 60;
        int mdelta = delta % 60;
        // add minute first
        if (minute + mdelta <= 59) minute = minute + mdelta;
        else {
            if (hour < 23) {
                hour++;
            }
            else {
                hour = 0;
            }
            minute = (minute + mdelta) % 60;
        }
        // add hour
        hour = (hour + hdelta) % 24;

    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock a = new Clock(12, 59);
        Clock b = new Clock("23:59");
        StdOut.println(a.toString());
        StdOut.println(b.toString());
        StdOut.println(a.isEarlierThan(b));
        a.tic();
        StdOut.println(a.toString());
        b.toc(90);
        StdOut.println(b.toString());


    }
}
