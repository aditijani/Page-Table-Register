package operatingSystem.Assignment2;

import java.util.ArrayList;

/**
 * Created by parthgodhani on 12/4/17.
 */
public class PageTable {
    int totalEntries =0;
    ArrayList<PageEntry> pageTabeData;
    //short[] allocatedFrames;
    FIFO fifo;


    public PageTable(short pages,short frames){
        totalEntries =pages;
        pageTabeData=new ArrayList<>(totalEntries);
        //allocatedFrames=new short[frames];
        fifo=new FIFO(frames);

    }


    public boolean addEntry(PageEntry p){
       //int a= allocatedFrames.length;

        if(pageTabeData.size()< totalEntries)
        {
            pageTabeData.add(p);
            return true;
        }
        else{
            return false;
        }

    }

    public PageEntry getPageEntrybyPageNo(short pageNo){
        for(PageEntry pageEntry:pageTabeData){
            if(pageEntry.pageNo==pageNo)
                return pageEntry;

        }
        return null;
    }

    public void printFullPageTable(){
        System.out.println("\n==========================================");
        System.out.println("Page No\tFrame No\tSector No\tValid Bit");
        System.out.println("===========================================");
        for(PageEntry pageEntry:pageTabeData){
            System.out.println("| "+pageEntry.pageNo+"\t\t|"+pageEntry.frameNo+"\t\t\t|"+pageEntry.secNo+"\t\t| "+pageEntry.VoI+"\t |");
        }
        System.out.println("==========================================");
    }


    public boolean updateVoIbit(short pageNo,boolean valInvBitStatus){
        for(PageEntry pageEntry:pageTabeData){
            if(pageEntry.pageNo==pageNo){
                pageEntry.VoI=valInvBitStatus;
                return true;
            }
        }
        return false;
    }


    public boolean updateFrameNo(short pageNo,short frameNo){
        for(PageEntry pageEntry:pageTabeData){
            if(pageEntry.pageNo==pageNo){
                pageEntry.frameNo=frameNo;
                return true;
            }
        }
        return false;
    }

    public short getPageNobyFrameNo(short frameNo){
        for(PageEntry pageEntry:pageTabeData){
            if(pageEntry.frameNo==frameNo){
                return pageEntry.pageNo;
            }
        }
        return 0;
    }




}
 class PageEntry{
    short pageNo;
    short frameNo;
    int secNo;
    boolean VoI;

    public PageEntry(short pno,short fno,int sno,boolean VoI){
        pageNo=pno;
        frameNo=fno;
        secNo=sno;
        this.VoI=VoI;
    }



 }
