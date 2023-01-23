package model;

/**
 *
 * @author Eduardo
 */
public class Timer {
    private int defaultShortBreak = 5;
    private int defaultBigBreak = 25;
    private int shortBreak;
    private int bigBreak;

    public Timer() {
        setShortBreak(defaultShortBreak);
        setBigBreak(defaultBigBreak);
    }

    public Timer(int shortBreak, int bigBreak) {
        setShortBreak(shortBreak);
        setBigBreak(bigBreak);
    }

    public int getShortBreak() {
        return shortBreak;
    }

    public void setShortBreak(int shortBreak) {
        this.shortBreak = shortBreak;
    }

    public int getBigBreak() {
        return bigBreak;
    }

    public void setBigBreak(int bigBreak) {
        this.bigBreak = bigBreak;
    }

    @Override
    public String toString() {
        return "timer{" + "defaultShortBreak=" + defaultShortBreak + ", defaultBigBreak=" + defaultBigBreak + ", shortBreak=" + shortBreak + ", bigBreak=" + bigBreak + '}';
    }
}
