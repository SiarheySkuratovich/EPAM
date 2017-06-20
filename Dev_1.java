public class Dev_1 {
    public static void main(String[] args){
        int temp;
        for(int i = 0; i <= 100; i++) {
            if(i % 3 == 0) {
                temp = i / 3;
                System.out.println("3*" + temp);
            }
            else {
                System.out.println(i);
            }

        }
    }
}
