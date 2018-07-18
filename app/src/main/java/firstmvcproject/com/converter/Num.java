package firstmvcproject.com.converter;

/**
 * Created by Akshay on 3/5/2016.
 */

public class Num {
    public static double convert(double kb, String choice){
        switch(choice.toLowerCase()){
            case "kb to b":
                return kb*1024;
            case "kb to mb":
                return kb/1024;
            case "kb to gb":
                return (kb/1024)/1024;
            default:
                return kb;
        }
    }
}
