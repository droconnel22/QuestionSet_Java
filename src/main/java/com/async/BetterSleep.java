package com.async;

public interface BetterSleep {
    static<T extends Number>  void Sleep(T interval) {
        try {
            if((Long)interval < 0){
                throw new IllegalArgumentException("Positive only");
            }
            Thread.sleep((Long)interval);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
