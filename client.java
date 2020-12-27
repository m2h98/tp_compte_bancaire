import java.rmi.Naming;


public class Client {

    public static void main(String[] args) {
        try {
            MyInterface serv = (MyInterface) Naming.lookup("rmi://127.0.0.1:1250/server");
            serv.crediter(1000);
            serv.debiter(100);
            System.out.println(service1.lireSolde());

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.toString());
        }
    }

}
