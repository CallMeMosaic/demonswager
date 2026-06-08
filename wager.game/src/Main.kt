//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        Narrator narrator = new Narrator(0,0,"Narrator",0,0,0,0,0);
        Actor demon = new Demon(100,100,"Demon",1,2,2,1
        ,2);

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

        narrator.speak(true, "And so the Player drew the card the fool!");
        Card Fool = new Card(0,"None","The Fool",true);
        Card KingP = new Card(13,"Pentacles", "King of Pentacles",false);
        Card KingS = new Card(13,"Swords", "King of Swords",false);
        KingS.getValue(KingS.isUpside(true),true);
        narrator.speak(true, "And so the Player drew the card " + KingP.get("name",false));
        Fool.getValue(Fool.isUpside(true),true);
        }
    }