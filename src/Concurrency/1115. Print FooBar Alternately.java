
/**
 1115. Print FooBar Alternately
 */

class FooBar {
    private int n;
    boolean flag;
    public FooBar(int n) {
        this.n = n;
        this.flag = false;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(this) {
                if(flag){
                    this.wait();
                }
                flag = true;
                printFoo.run();
                this.notifyAll();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized(this) {
                if(!flag){
                    this.wait();
                }
                flag = false;
                printBar.run();
                this.notifyAll();
            }
        }
    }
}