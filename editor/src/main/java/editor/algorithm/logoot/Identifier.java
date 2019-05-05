package editor.algorithm.logoot;

import editor.Configuration;

import java.io.Serializable;

public class Identifier implements Serializable, Comparable<Identifier> {
    private int digit;
    private String siteId;

    public Identifier(int digit){
        this.digit=digit;
        this.siteId= Configuration.getProcessId();

    }


    @Override
    public int compareTo(Identifier o) {
        if(this.digit<o.getDigit()){
            return -1;
        }
        else if(this.digit>o.getDigit()){
            return 1;
        }
        else {
            return this.siteId.compareTo(o.getSiteId());
        }
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }



}
