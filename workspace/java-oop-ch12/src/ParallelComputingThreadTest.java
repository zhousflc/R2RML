/**
 * ʹ��Thread�������ʵ���̣߳��书��Ϊѭ�����0-9���֣�ÿ��������߲���10�����ʱ�䡣
 * ��main()�����д��������������̣߳��������С������߳̿�ʼ��������Ҫ����Ӧ������������ 
 */

// TestMitiThread.java
public class ParallelComputingThreadTest {
    public static void main(String[] rags) {
        System.out.println("main�߳����п�ʼ!");
        new ParallelComputingThread("A", 1, 20).start();
        new ParallelComputingThread("B", 21, 30).start();
        System.out.println("main�߳����н���!");
    }
}
 
class ParallelComputingThread extends Thread {
    
	private int number1;
	private int number2;
	
	public ParallelComputingThread(String threadName, int number1, int number2) {
        super(threadName);
        this.number1 = number1;
        this.number2 = number2;
    }
	
	private long fun() {//long n1, long n2) {
		long fun1 = 1l;
		for(long i = number1; i <= number2; i++) {
			fun1 *= i;
		}
		return fun1;
	}
    
    public void run() {
        System.out.println(getName() + " �߳����п�ʼ!");
        System.out.println("" + number1 +"--->" + number2 + "  " + fun());
//        try {
//        	sleep(1000);//(int) Math.random() * 1000);
//        } catch (InterruptedException e) {
//        	e.printStackTrace();
//        }
        
        System.out.println(getName() + " �߳����н���!");
    }
}
