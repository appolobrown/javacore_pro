package ru.geekbrains.javacore.lesson4;

public class Main {


    public static void main(String[] args) {
//        Thread threadA = new Thread(new LetterPrinter('A', 'B'));
//        threadA.start();
//        Thread threadB = new Thread(new LetterPrinter('B', 'C'));
//        threadB.start();
//        Thread threadC = new Thread(new LetterPrinter('C', 'A'));
//        threadC.start();

        MultiFuncUnit multiFuncUnit = new MultiFuncUnit();
        new Thread(new PrinterMan(multiFuncUnit)).start();
        new Thread(new ScannerMan(multiFuncUnit)).start();
        new Thread(new CopyMan(multiFuncUnit)).start();

        new Thread(new CopyMan(multiFuncUnit)).start();
        new Thread(new CopyMan(multiFuncUnit)).start();
        new Thread(new PrinterMan(multiFuncUnit)).start();

        new Thread(new ScannerMan(multiFuncUnit)).start();
        new Thread(new ScannerMan(multiFuncUnit)).start();
        new Thread(new PrinterMan(multiFuncUnit)).start();

    }


    private static class PrinterMan extends BaseMfuUser {

        public PrinterMan(MultiFuncUnit multiFuncUnit) {
            super(multiFuncUnit);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    multiFuncUnit.print(String.format("Print job %d %s", i, this.toString()));
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private static class ScannerMan extends BaseMfuUser {
        public ScannerMan(MultiFuncUnit multiFuncUnit) {
            super(multiFuncUnit);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    multiFuncUnit.scan(String.format("Scanning job %d %s", i, this.toString()));
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private static class CopyMan extends BaseMfuUser {
        public CopyMan(MultiFuncUnit multiFuncUnit) {
            super(multiFuncUnit);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    multiFuncUnit.copy(String.format("Copy job %d %s", i, this.toString()));
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private static class BaseMfuUser implements Runnable {
        MultiFuncUnit multiFuncUnit;

        public BaseMfuUser(MultiFuncUnit multiFuncUnit) {
            this.multiFuncUnit = multiFuncUnit;
        }

        @Override
        public void run() {
            try {
                multiFuncUnit.copy(this.toString());
                multiFuncUnit.print(this.toString());
                multiFuncUnit.scan(this.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

