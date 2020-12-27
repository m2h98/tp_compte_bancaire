import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements MyInterface {

    public Server() throws RemoteException {}
    private double solde;

    public String debiter(double x){
        if (solde==0)
        {
            return "plus de solde ";
        }
        else {
            solde-=x;
            return "solde debité";
        }
    }
    public String crediter (double x) {
        solde+=x;
        return "solde credité";
    }
    public double lireSolde()
    {
        return solde;
    }
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);
    }
}
