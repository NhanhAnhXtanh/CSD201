
public class Main {
//    public static void main(String[] args) {
//        Stack a = new Stack();
//        String b = "E A S * Y * Q U E * * S T * I O * N * * *";
//        String e = "";
//        for (int i = 0; i < b.length(); i++) {
//            char c = b.charAt(i);
//            if(Character.isAlphabetic(c)){
//                e += a.push(x);
//            }else if(c == ' '){
//                
//            }else {
//                e +=
//            }
//        }
//    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        Student student = new Student("HE181818","Anh", 10);
        stack.push(student);
        System.out.println(stack.pop());
    }
}
