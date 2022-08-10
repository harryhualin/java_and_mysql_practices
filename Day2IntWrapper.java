public class Day2IntWrapper {
    private int i;
    public Day2IntWrapper(int a) {
        this.i = a;
    }

    public int getValue() {
        return i;
    }

    public void setValue(int a) {
        this.i = a;
    }
    public int intValue()  {
        return this.i;}
    public short shortValue() {
        return (short) this.i;
    }
    public boolean equals(int a){
        return this.i==a;
    }
    @Override
    public String toString() {
        return Integer.toString(i);
    }
}
