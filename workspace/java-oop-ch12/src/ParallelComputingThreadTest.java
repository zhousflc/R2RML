/**
 * 使用Thread类的子类实现线程，其功能为循环输出0-9数字，每次随机休眠不到10毫秒的时间。
 * 在main()方法中创建两个这样的线程，启动运行。所有线程开始、结束都要有相应的文字描述。 
 */

// TestMitiThread.java
public class ParallelComputingThreadTest {
    public static void main(String[] rags) {
        System.out.println("main线程运行开始!");
        new ParallelComputingThread("A", 1, 20).start();
        new ParallelComputingThread("B", 21, 30).start();
        System.out.println("main线程运行结束!");
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
        System.out.println(getName() + " 线程运行开始!");
        System.out.println("" + number1 +"--->" + number2 + "  " + fun());
//        try {
//        	sleep(1000);//(int) Math.random() * 1000);
//        } catch (InterruptedException e) {
//        	e.printStackTrace();
//        }
        
        System.out.println(getName() + " 线程运行结束!");
    }
}
