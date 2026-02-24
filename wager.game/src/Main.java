//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        demon demon = new demon();
        demon.speak(true, "THIS IS THE DEMON! ");
        demon.setValue("health",100,true);
        demon.changeValue("balance",100,true,true);
        double temp = demon.getValue("health",false);
        demon.speak(true, "MY HEALTH IS "+ temp);
        demon.stageValue(1,true,1);
        demon.stageValue(1,true,2);
        demon.stageValue(5,true,3);
        demon.stageValue(1,true,4);
        demon.stageValue(1,true,5);
        demon.setValue("balance",100,true);
        }
    }