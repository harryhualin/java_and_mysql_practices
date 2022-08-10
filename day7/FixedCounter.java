package day7;



class NewTest{
    static int i=10;
    synchronized void increment()
    {
        for(int j=0;j<50;j++)
        {
            // incrementing value of i
            i=i+1;
            System.out.println("i after increment "+i);
        }
    }
    synchronized void decrement()
    {
        for(int j=0;j<50;j++)
        {
            // decrementing value of i
            i=i-1;
            System.out.println("i after decrement "+i);
        }
    }

}

class FixedCounter {
    public static void main(String[] args)
    {
        final NewTest s1 = new NewTest();
        Thread t1 = new Thread()
        {
            @Override
            public void run()
            {
                s1.increment();
            }
        };
        Thread t2 = new Thread()
        {
            @Override
            public void run()
            {
                s1.decrement();
            }
        };
        t1.start();
        t2.start();
    }
}

