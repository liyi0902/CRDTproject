package editor.algorithm.treedoc;

import editor.Configuration;

public class Disambiguator {
    private String uid;
    private int counter;

    public Disambiguator(){
        this.counter=Configuration.getCounter();
        this.uid= Configuration.getProcessId();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }


    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)){
            return true;
        }
        else {
            return this.uid.equals(((Disambiguator)obj).getUid())&&this.counter==((Disambiguator)obj).getCounter();
        }

    }
}
