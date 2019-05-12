package editor.algorithm.logoot;

import editor.Configuration;

import java.io.Serializable;

/**
 *  An identifier is a couple ⟨pos, site⟩ where pos is an integer and site a site identifier.
 */
public class Identifier implements Serializable, Comparable<Identifier> {
    private int digit;
    private String siteId;

    public Identifier(int digit){
        this.digit=digit;
        this.siteId= Configuration.getProcessId();

    }

    public Identifier(int digit,String siteId){
        this.digit=digit;
        this.siteId=siteId;

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

    @Override
    public String toString() {
        return "Identifier{" +
                "digit=" + digit +
                ", siteId='" + siteId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)){
            return true;
        }
        if(obj==null||this.getClass()!=obj.getClass()){
            return false;
        }
        Identifier identifier=(Identifier)obj;
        return this.compareTo(identifier)==0;

    }
}
