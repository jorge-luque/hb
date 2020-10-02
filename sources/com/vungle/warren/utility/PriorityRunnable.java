package com.vungle.warren.utility;

public abstract class PriorityRunnable implements Comparable, Runnable {
    public int compareTo(Object obj) {
        if (!(obj instanceof PriorityRunnable)) {
            return -1;
        }
        return ((PriorityRunnable) obj).getPriority().compareTo(getPriority());
    }

    public abstract Integer getPriority();
}
