import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Administrator on 9/18/2017.
 */
public class Test {
    public static void main(String[] args) {
        String string = "";
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        while(sc.hasNext())
            string += sc.nextLine() +" ";
        sc.close();
        String[] literalList = string.split("\\s+");
        HashMap<String,Integer> variable = new HashMap<String, Integer>();
        HashMap<String ,Integer> label = new HashMap<>();

        for(int i = 0 ; i < literalList.length; i++){
            switch (literalList[i]){
                case "SET":{
                    variable.put(literalList[i+1],Integer.parseInt(literalList[i+2]));
                    i+=2;
                    break;
                }
                case "LABEL":{
                    label.put(literalList[i+1],i+1);
                    i+=1;
                    break;
                }

            }
        }
        int ifCounter = -1;
        for(int i = 0 ;i < literalList.length;i++){
            switch (literalList[i]){
                case "GOTO":{
                    i = label.get(literalList[i+1]);
                    break;
                }
                case "IF":{
                    if(variable.get(literalList[i+1]) == Integer.parseInt(literalList[i+2])){
                        ifCounter = i;
                        i+=2;
                    }else {
                        int conditionCount =0 ;
                        for( i=i+1;i<literalList.length;i++){
                            if(literalList[i].equals("END") && conditionCount == 0)
                                break;
                            else if(literalList[i]=="END")
                                conditionCount--;
                            if(literalList[i]=="IF")
                                conditionCount++;
                        }
                    }
                    break;
                }
                case "ADD" : {
                    int add=0;
                    if(variable.containsKey(literalList[i+1])){
                        add = variable.get(literalList[i+1]);
                    }else{
                        add = Integer.parseInt(literalList[i+1]);
                    }
                    if(variable.containsKey(literalList[i+2])){
                        add += variable.get(literalList[i+2]);
                    }else{
                        add += Integer.parseInt(literalList[i+2]);
                    }

                    variable.replace(literalList[i+3],add);
                    i+=3;
                    break;
                }
                case "ECHO":{
                    if(variable.containsKey(literalList[i+1]))
                        System.out.println(variable.get(literalList[i+1]));
                    else
                        System.out.println(literalList[i+1]);
                    break;
                }
                case "EXIT":{
                    System.exit(0);
                }
                case "CONTINUE":{
                    i = ifCounter;
                    break;
                }
            }
        }
    }
}