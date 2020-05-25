package JavaCore.multithreading.synchronization.wait_notify.demo4;

public class Demo4 {
    public static void main(String[] args) throws Exception{
        Account4 account = new Account4(1000);

        new DepositThread(account).start();

        System.out.println("Calling waitWithdraw().....");

        //подождать и снять 1000
        account.waitAndWithdraw(1000);

        System.out.println("Calling waitWithdraw() finished");

        Thread withDrawThread = new WithdrawThread(account);
        Thread depositThread = new DepositThread(account);

        withDrawThread.start();
        depositThread.start();

        withDrawThread.join();
        depositThread.join();

        System.out.println("End balance = " + account.getBalance());
    }

    //снятие наличных
    private static class WithdrawThread extends Thread{
        private final Account4 account4;

        public WithdrawThread(Account4 account4) {
            this.account4 = account4;
        }

        @Override
        public void run(){
            for (int i = 0; i < 1; ++i) {
                account4.withdraw(1000);
            }
        }
    }

    //поплнение наличных
    private static class DepositThread extends Thread{
        private final Account4 account4;

        public DepositThread(Account4 account4) {
            this.account4 = account4;
        }

        @Override
        public void run(){
            for (int i = 0; i < 1; ++i) {
                account4.deposit(1000);
            }
        }
    }
}
