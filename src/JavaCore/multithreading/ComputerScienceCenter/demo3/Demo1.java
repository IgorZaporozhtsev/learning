package JavaCore.multithreading.ComputerScienceCenter.demo3;

public class Demo1 {
    public static void main(String[] args) throws Exception{
        Account account = new Account(100_000_000);

        System.out.println("Begin balance = " + account.getBalance());

        Thread withDrawThread = new WithdrawThread(account);
        Thread depositThread = new DepositThread(account);

        withDrawThread.start();
        depositThread.start();

        withDrawThread.join();
        depositThread.join();

        System.out.println("End balance = " + account.getBalance());
    }


    private static class WithdrawThread extends Thread{
        private final Account account;

        public WithdrawThread(Account account) {
            this.account = account;
        }

        @Override
        public void run(){
            for (int i = 0; i < 200_000; ++i) {
                account.withdraw(1);
            }
        }
    }

    private static class DepositThread extends Thread{
        private final Account account;

        public DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run(){
            for (int i = 0; i < 200_000; ++i) {
                account.deposit(1);
            }
        }
    }
}
