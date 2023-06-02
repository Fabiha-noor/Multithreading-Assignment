import java.util.*;
import java.lang.*;


public class Chat {
	int flag = 1;
			public synchronized void Person1(boolean last, String msg) {
				while (flag!=1) {
				try {
					wait();
				} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
					System.out.println(msg);
					flag = 2;
					if(last) {flag = 3;}
					notify();
				}
				
			public synchronized void Person2(String msg) {
				while (flag!=2) {
					try {
						wait ();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(msg);
				flag = 3;
				notify();
			}
			
			public synchronized void Person3(String msg) {
				while (flag!=3) {
					try {
						wait ();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(msg);
				flag = 1;
				notify();
			}
		}
	        class T1 implements Runnable {
	            Chat m;
	            String [] s1 = { "Hi", "How are you guys?", "I'm also doing great", "How's your life?"};
	            public T1 (Chat m1) {
	                this.m = m1;
	                new Thread (this, "Person1").start();
	            }
	            public void run () {
	                for (int i =0; i<s1.length; i++) {
						
	                    m.Person1(i==(s1.length-1), "Person1: "+s1[i]);
	                }
	            }
	        }
	        
			class T2 implements Runnable {
	            Chat m;
	            String [] s2 = { "Hey", "Fine", "Great." };
	            public T2 (Chat m2) {
	                this.m = m2;
	                new Thread (this, "Person2").start();
	            }
	            public void run () {
	                for (int i =0; i<s2.length; i++) {
	                    m.Person2("Person2: "+s2[i]);
	                }
	            }
	        }
			
			class T3 implements Runnable {
	            Chat m;
	            String [] s3 = { "Hello", "I'm well. What about you?", "I see.", "On going"};
	            public T3 (Chat m3) {
	                this.m = m3;
	                new Thread (this, "Person3").start();
	            }
	            public void run () {
	                for (int i =0; i<s3.length; i++) {
	                    m.Person3("Person3: "+ s3[i]);
	                }
	            }
	        }
	        
	        public class TestThread {
	        public static void main(string args[]){
	        chat m = new chat ();
	        new T1(m);
	         new T2(m);
	          new T3(m);
	        }
	        }

