import model.Msg;
import model.User;
import java.util.ArrayList;
import java.util.List;
import controller.Sistema;

public class App {
    public static void main(String[] args) throws Exception{
        Sistema sistema = new Sistema();
        sistema.addUser("pedro");
        sistema.addUser("edivaldo");
        sistema.addUser("yago");

        sistema.sendMsg("yago", "pedro", "ou me paga ou morre");
        System.out.print(sistema.readMsgs("pedro"));
        sistema.sendMsg("pedro", "edivaldo", "corre carniça, to em risco de vida");
        System.out.print(sistema.readMsgs("pedro"));
        System.out.print(sistema.readMsgs("edivaldo"));
        sistema.sendMsg("edivaldo", "pedro", "ja to na esquina, corre que eu passo de moto");
        System.out.print(sistema.readMsgs("pedro"));


    }
}
