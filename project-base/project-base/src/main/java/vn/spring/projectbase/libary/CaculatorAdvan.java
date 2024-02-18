package vn.spring.projectbase.libary;

public class CaculatorAdvan implements  CaculatorInterface{

    @Override
    public int congHaiSo(int a, int b) {
       return a + b ;
    }

    @Override
    public int truHaiSo(int a, int b) {
        return a - b ;
    }

    @Override
    public double binhPhuong(double a) {
        return Math.pow(a,2);
    }

    @Override
    public double canBacHai(double a) {
        return Math.sqrt(a);
    }
}
