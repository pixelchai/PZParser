package com.pixelzerg.parser;

/**
 * Created by pixelzerg on 29/01/17.
 */
public class Scanner {
    public String filepath = "";
    public String source = null;
    public int curindex = 0;
    private Pos lpos = new Pos();
    private int lindex = 0;

    public Scanner(String source) {
        setSource(source);
    }

    public Scanner(String filepath, String source) {

        this.filepath = filepath;
        setSource(source);
    }

    public void setSource(String source){
        //TODO stuff
    }

    public char getCur(){
        return this.charAt(curindex);
    }

    public char charAt(int index){
        if(curindex>=source.length())return (char)-1;
        return source.charAt(index);
    }

    public char look(int off){
        if(curindex+off>=source.length())return (char)-1;
        return source.charAt(curindex+off);
    }

    public void increment(int x){
        curindex+=x;
    }

    public Pos getPos() {
        Pos ret = lpos.clone();
        int i;
        for (i = lindex; i <= curindex; i++) {
            if(this.charAt(i)=='\n'){
                ret.lineno++;
                ret.charno=0;
            }else{
                ret.charno++;
            }
        }
        lindex=i;
        lpos=ret;
        return ret;
    }

    public Pos getPos(int lookahead) {
        Pos ret = lpos;
        int i;
        for (i = lindex; i < curindex+lookahead; i++) {
            if(this.charAt(i)=='\n'){
                ret.lineno++;
                ret.charno=0;
            }else{
                ret.charno++;
            }
        }
        return ret;
    }
}
