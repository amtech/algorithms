package nowCoder.thread;

import java.util.ArrayList;
import java.util.List;

public class NameList {
	private List names = new ArrayList();

	public synchronized void add(String name) {
		names.add(name);
	}

	public synchronized void printAll() {
		for (int i = 0; i < names.size(); i++) {
			System.out.print(names.get(i) + "");
		}
	}

	public static void main(String[] args) {
		final NameList sl = new NameList();
		/*for (int i = 0; i < 2; i++) {
			new Thread() {
				public void run() {
					sl.add("a");
					sl.add("b");
					sl.add("c");
					sl.printAll();
				}
			}.start();
		}*/
		Thread t1 = new Thread() {
            public void run() {
                sl.add("A");
                sl.add("B");
                sl.add("C");
                sl.printAll();
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            public void run() {
                sl.add("A");
                sl.add("B");
                sl.add("C");
                sl.printAll();
            }
        };
        t2.start();
        try {
            t1.join();
            t2.join();
            } catch(InterruptedException e) { 
        // TODO Auto-generated catch block 
        e.printStackTrace(); 
        } 
        System.out.println(); 
        sl.printAll(); 
	}
	/**
	 * Êä³ö½á¹û 
	 * 1.aabbccaabbcc
	 * 2.abcabcabc
	 * 
	 */
}
