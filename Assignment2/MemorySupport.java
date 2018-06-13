package operatingSystem.Assignment2;

import java.util.HashMap;

/**
 * Created by parthgodhani on 12/4/17.
 */
public class MemorySupport {
    static HashMap<Short,Boolean> frames=new HashMap<Short, Boolean>();
    static HashMap<Short,Boolean> sectors=new HashMap<Short, Boolean>();
    //Program program=new Program();
    short MAX_FRAMES=0x40;
    short MAX_SEC=Short.MAX_VALUE;
    public short getNextAvailableFrame(){
        short frameNo=(short)(Math.random()* MAX_FRAMES);
        while(true){
            if(frames.get(frameNo)==null){
                frames.put(frameNo,false);
                return frameNo;
            }
            else{
                frameNo=(short)(Math.random()* MAX_FRAMES);
            }

        }
        //return (short)(Math.random()*30);
    }
    public short getNextFreeSec(){
        short frameNo=(short)(Math.random()* MAX_SEC);
        while(true){
            if(sectors.get(frameNo)==null){
                sectors.put(frameNo,false);
                return frameNo;
            }
            else{
                frameNo=(short)(Math.random()* MAX_SEC);
            }

        }
    }
}
