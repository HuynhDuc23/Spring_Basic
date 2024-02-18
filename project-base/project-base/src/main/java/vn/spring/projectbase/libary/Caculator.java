package vn.spring.projectbase.libary;
// giả sử đây là một thư viện bên ngoài chúng ta không thể can thiệp được vào , để bean quản lý
// Giả sử đây là một thư viện để tính toán
public class Caculator implements CaculatorInterface {
    @Override
    public int congHaiSo(int a , int b){
        return a + b ;
    }
    @Override
    public int truHaiSo(int a, int b){
        return a - b ;
    }
    @Override
    public double binhPhuong(double a){
        return Math.pow(a,2);
    }
    @Override
    public double canBacHai(double a){
        return Math.sqrt(a);
    }
}
