package com.oliver.övningsuppgifter.why;

public class Svara implements Tenta {
    public String answer() {
        String answer = "Svaret är 42. ";
        return answer;
    }
    public String echo(String s) {
        return answer() + s;
    }
}
